package rudgusee.DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 4 || n == 7){
            // 정확하게 N킬로그램을 만들 수 없을 때: 3과 5로 구성하지 못하는 수
            System.out.println(-1);
        } else if (n % 5 == 0) {
            //n 이 5의 배수인경우 ( 5로 나눈 나머지가 0 인 경우 )
            System.out.println(n / 5);
        } else if (n % 5 == 1 || n % 5 == 3) {
            //n 이 5의 배수 + 1 또는 5의 배수 + 3 인 경우 ( 5로 나눈 나머지가 1 또는 3 인 경우 )
            //5의 배수 + 3 의 자리는 5의 배수에 있던 값의 +1 개수
            System.out.println((n / 5) + 1);
        } else if (n % 5 == 2 || n % 5 == 4) {
            //n 이 5의 배수 + 2 또는 5의 배수 + 4 인 경우 ( 5로 나눈 나머지가 2 또는 4 인 경우 )
            //< 5의 배수 + 2 번째 >의 봉투의 개수는 (n / 5) + (n % 5) 이때 n % 5 는 항상 2
            //해당 값은 5의 배수 +4 번째의 봉투의 개수와 같다.
            //(5의 배수 + 2) 과 (5의 배수+ 4) 은 5로 나눈 몫의 + 2 가 봉지 개수
            System.out.println((n / 5) + 2);
        }
    }

}
