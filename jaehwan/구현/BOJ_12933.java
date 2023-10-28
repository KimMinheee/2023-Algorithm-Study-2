import java.util.*;
import java.io.*;

public class BOJ_12933 {//[BOJ_12933]오리 jaehwan solved  
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String quack = "quack";
        String n = br.readLine();
        int answer = 0;
        boolean[] ck = new boolean[n.length()];

        if (n.length() % 5 != 0) {
            answer = -1;
        } else {
            for (boolean done = false; !done;) {//무한루프
                int i = 0;
                int j = 0;
                int count = 0;
                for (done = true; j < n.length(); j++) {
                    if (ck[j]) {
                        count++;
                    }
                    if (!ck[j] && quack.charAt(i % 5) == n.charAt(j)) {//사용하지 않은 문자이고,quack의 일부인 경우
                        ck[j] = true;
                        i++;
                        done = false;
                    }
                }
                if (i / 5 > 0) {//quack가 한번 완성되면 체크
                    answer++;
                } else {
                    if (count == n.length()) {//모든문자사용 탈출
                        break;
                    }

                    answer = -1; //탈출 불가 남은 문자있으면 -1
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}

/*
왜 틀린지 모르겠는 코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12933 {
    static int q = 0;
    static int u = 0;
    static int a = 0;
    static int c = 0;
    static int k = 0;
    static int qCount = 0;
    static int uCount = 0;
    static int aCount = 0;
    static int cCount = 0;
    static int kCount = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int answer = -1;

        String n = br.readLine();
        if (n.length() % 5 != 0) {
            answer = -1;
        } else {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) == 'q') {
                    q++;
                    qCount++;
                }
                if (n.charAt(i) == 'u' && q > u) {//앞에 글자가 항상 하나 더 많아야함
                    u++;
                }
                if (n.charAt(i) == 'a' && u > a) {
                    a++;
                }
                if (n.charAt(i) == 'c' && a > c) {
                    c++;
                }
                if (n.charAt(i) == 'k' && c > k) {
                    k++;
                }
                //개수
                if (n.charAt(i) == 'u') {
                    uCount++;
                }
                if (n.charAt(i) == 'a') {
                    aCount++;
                }
                if (n.charAt(i) == 'c') {
                    cCount++;
                }
                if (n.charAt(i) == 'k') {
                    kCount++;
                }
            }
            quackFind();
        }

        if (flag == true) {//올바른 후보
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) == 'q') {
                    count++;
                }
                if (n.charAt(i) == 'k') {
                    answer = Math.max(answer, count);
                    count = 0;
                }
            }
            if (answer == 0) {
                answer = -1;
            }
            System.out.print(answer);
        } else {
            System.out.print(-1);
        }
    }
    public static void quackFind() {
        //서로의 개수가 다른경우
        if (qCount == uCount && uCount == aCount && aCount == cCount && cCount == kCount
        && q==u && u==a && a==c && c==k) {
            flag = true;
        } else {
            flag = false;
        }
    }
}
1.이 문장이 옳은 문장인지 계산
2.q가 시작할때 다음 k안에 몇개의 q가 존재하는지 알아내면서 최대값을 갱신
(quack안에 겹치는 인덱스 값이 얼마나 있는지 계산하며 최대 겹치는 값을 갱신)

반례

*/


