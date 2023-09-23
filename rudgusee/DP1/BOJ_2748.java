package rudgusee.DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //n은 90보다 작거나 같은 자연수
        //long형 배열: 90번째 피보나치 수는 int형의 범위를 초과하기 때문에 사용
        long[] arr = new long[n+1];
        arr[0] = 0; //0번째, 1번째 피보나치 숫자는 미리 저장
        arr[1] = 1;

        for(int i=2; i<=n; i++){ //2번 숫자부터 피보나치 수의 합 반복 시작
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[n]); // n번째 피보나치 수 출력
    }


}
