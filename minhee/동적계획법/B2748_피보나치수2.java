package minhee.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2748_피보나치수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int idx = 2; idx <= n; idx++) {
            dp[idx] = dp[idx-1] + dp[idx-2];
        }

        System.out.println(dp[n]);
        br.close();
    }
}
