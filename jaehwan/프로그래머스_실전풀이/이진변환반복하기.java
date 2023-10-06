package study_W1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 이진변환반복하기 { //[PGM-70129]이진변환반복하기 jaehwan solved
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] answer= solution.solution("110010101001");//TEST CASE

        for(int i=0;i< answer.length;i++){
            System.out.println(answer[i]);
        }
    }
    static class Solution {
        public int[] solution(String s) { //s로 값을 받음(이진수)

            int count=0;//몇번 이진 변환 했는지 
            int zeroNum=0;//0몇개 제거 했는지

            while(!s.equals("1")){
                int c=0;//자리수 체크
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='0'){
                        zeroNum++; 
                    }
                    else {
                        c++;
                    }
                }
                s=Integer.toBinaryString(c);//십진수를 이진수로 바꿔줌
                count++;
            }
            int[] answer =new int[2];
            answer[0]=count;
            answer[1]=zeroNum;
            return answer;
        }
    }
}
/*
110010101001->111111->110->11->10->1
이진변환 3번 제거된 0의 개수 = 8개 ->[3,8]
*/
