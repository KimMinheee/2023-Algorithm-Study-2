package rudgusee.DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        System.out.println(recur(x, 0));
    }

    static int recur(int n, int cnt) {
        if (n < 2) {
            // N이 2 미만인 경우 누적된 count값을 반환
            return cnt;
        }
        //count만 누적해주면서 나눗셈과 나머지 값을 이용하여 count를 갱신
        //N으로 각각 2와 3으로 나누면 count는 +1에 각 연산의 나머지 값을 더해준 것이 된다.
        //나머지 값은 빼기 1했을 때의 count 값과 같기 때문이다.
        return Math.min(recur(n / 2, cnt + 1 + (n % 2)), recur(n / 3, cnt + 1 + (n % 3)));
    }
}
