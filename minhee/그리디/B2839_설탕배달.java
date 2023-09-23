package minhee.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = -1;

        int fiveCount = N / 5;
        for (int i = fiveCount; i >= 0; i--) {
            int tmp = N - (5 * i);
            if (tmp % 3 == 0) {
                answer = (i + (tmp / 3));
                break;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
