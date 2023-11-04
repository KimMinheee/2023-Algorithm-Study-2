package minhee.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16987_계란으로계란치기 {
    private static int N;
    private static Egg[] eggs;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(durability, weight);
        }

        dfs(0, 0); //가장 왼쪽 계란(0)부터 시작
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int index, int count) { //index = 손에 들고 있는 계란의 인덱스
        if (index == N) {
            answer = Math.max(count, answer);
            return;
        }

        if (eggs[index].durability <= 0 || count >= N - 1) {
            dfs(index + 1, count);
            return;
        }

        Egg e = eggs[index];
        for (int i = 0; i < N; i++) {
            if (eggs[i].durability <= 0 || index == i) continue;

            e.durability -= eggs[i].weight;
            eggs[i].durability -= e.weight;

            int crushedEggCount = 0;
            if (eggs[index].durability <= 0) crushedEggCount++; //깨진 것
            if (eggs[i].durability <= 0) crushedEggCount++;

            dfs(index + 1, count + crushedEggCount);

            //원복
            e.durability += eggs[i].weight;
            eggs[i].durability += e.weight;
        }
    }
}

class Egg {
    int durability; //내구도
    int weight; //무게

    public Egg(int durability, int weight) {
        this.durability = durability;
        this.weight = weight;
    }
}
