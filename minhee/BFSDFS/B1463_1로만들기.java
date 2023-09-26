package minhee.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;

        int answer = bfs(X, count);
        System.out.println(answer);
        br.close();
    }

    private static int bfs(int X, int count) {
        Queue<Info> que = new LinkedList<>();
        boolean[] visited = new boolean[X + 1];

        visited[X] = true;
        que.add(new Info(X, 0));

        while (!que.isEmpty()) {
            Info tmpInfo = que.poll();
            int tmpNum = tmpInfo.num;
            int tmpCount = tmpInfo.count;
            if (tmpInfo.num == 1) {
                return tmpCount;
            }

            if (tmpNum % 3 == 0 && !visited[tmpNum / 3]) {
                que.add(new Info(tmpNum / 3, tmpCount + 1));
            }
            if (tmpNum % 2 == 0 && !visited[tmpNum / 2]) {
                que.add(new Info(tmpNum / 2, tmpCount + 1));
            }
            if (tmpNum - 1 > 0 && !visited[tmpNum - 1]) {
                que.add(new Info(tmpNum - 1, tmpCount + 1));
            }
        }
        return 0;
    }
}

class Info {
    int num;
    int count;

    public Info(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
