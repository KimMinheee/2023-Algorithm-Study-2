package minhee.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class B16953_AB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int ans = 1;
        while (B != A) {
            if (B < A) {
                ans = -1;
                break;
            }

            String str = String.valueOf(B);

            if (str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
                ans = -1;
                break;
            }

            if (B % 2 == 0) { //2로 나누어 떨어진다면, 2로 나눈다.
                B /= 2;
            } else { //2로 나누어 떨어지지 않는다면, 1을 삭제한다.
                str = str.substring(0, str.length() - 1);
                B = Long.parseLong(str);
            }

            ans++; // 횟수 증가.
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

