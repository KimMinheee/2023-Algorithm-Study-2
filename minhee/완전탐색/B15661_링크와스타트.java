package minhee.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B15661_링크와스타트 {
//    static private int N;
//    static private int[][] map;
//    static private int answer = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        map = new int[N][N];
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        //꼭 N번까지 볼 필요 없음
//        for (int max = 1; max <= N / 2; max++) {
//            dfs(max, 0, 0, new ArrayList<>(), new ArrayList<>()); //1
//        }
//    }
//
//    private static void dfs(int max, int depth, int index, List<Integer> startTeam) {
//        if (depth == max) {
//            int diff = Math.abs(startValue - linkValue);
//            answer = Math.max(answer, diff);
//            return;
//        }
//
//        for (int i = index; i < N; i++) { //그다음 인덱스부터
//            startTeam.add(index);
//            dfs(max, depth + 1, index + 1, startTeam);
//        }
//    }
//
//    private static int getDiff(List<Integer> startTeam) {
//        //링크 팀에 넣어주기
//        List<Integer> linkTeam = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            if(!startTeam.contains(i)) linkTeam.add(i);
//        }
//
//        //정렬
//        Collections.sort(linkTeam);
//        Collections.sort(startTeam);
//
//        int startPoint = 0;
//        int endPoint = 1;
//        while(startPoint > endPoint){
//
//        }
//    }

}
