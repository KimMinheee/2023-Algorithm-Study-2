package minhee.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13164_행복유치원 {
    private static int N, K;
    private static int[] arr;
    private static int[] arrDiff;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        arrDiff = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            arrDiff[i] = arr[i + 1] - arr[i]; //2,2,1,4
        }
        Arrays.sort(arrDiff); //1,2,2,4

        /**
         * 위에서 구한 차이의 개수 = arrDiff의 사이즈 = N-1
         * 3개의 그룹을 만들기 위해서는 K-1(3-1)개의 구분선이 필요
         * 키차이의 개수를 구하면, N - 1 (5개의 입력값에서는 4개의 차이의 배열)
         * 구분선의 개수를 구하면, K - 1 (3개의 그룹을 가지려면 2개의 구분선 필요)
         * 예시로 설명하자면, 4에서 최소 2개만 선택
         * 즉, (N - 1) - ( K - 1 ) 만큼 더해주면 최소 배열이 된다.
         */
        for (int i = 0; i < (N - 1) - (K - 1); i++) { //결국 i<N-K
            answer += arrDiff[i];
        }

        System.out.println(answer);
        br.close();
    }
}
