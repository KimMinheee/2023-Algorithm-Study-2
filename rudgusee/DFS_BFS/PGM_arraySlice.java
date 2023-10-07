package rudgusee.DFS_BFS;

import java.util.Arrays;
import java.util.Collections;

public class PGM_arraySlice {
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left;
        int[] answer = new int[len + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            //n x n 배열일 때,
            //(i / n) + 1 은 행의 값, (i % n) + 1은 열의 값
            long row = i / n;
            long col = i % n;

            //row와 col 중 큰 값 + 1
            answer[idx++] = Math.max((int)row, (int)col) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        PGM_arraySlice pgmArraySlice = new PGM_arraySlice();
        System.out.println(Arrays.toString(pgmArraySlice.solution(3, 2, 5)));
        System.out.println(Arrays.toString(pgmArraySlice.solution(4, 7, 14)));
    }
}
