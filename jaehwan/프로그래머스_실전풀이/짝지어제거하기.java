package study_W1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class 짝지어제거하기 {//[짝지어 제거하기]jaehwan solved - 탐색 사용
    public static void main(String[] args) {
        Solution s=new Solution();
        int num=s.solution("baabaa");
        System.out.println(num);
    }
    static class Solution
    {
        public int solution(String s)
        {
            int answer = -1;
            Stack<Character> st =new Stack<>();
            for(int i=0;i < s.length();i++){
                if(st.size() == 0) {
                    st.push(s.charAt(i));
                    continue; //i값 이미 손댔기 때문에
                }
                if(st.peek() == s.charAt(i)){
                    st.pop();
                }
                else {st.push(s.charAt(i));}
            }
            if(st.size()==0) answer=1;
            else answer=0;

            return answer;
        }
    }
}
/*
110010101001->111111->110->11->10->1
이진변환 3번 제거된 0의 개수 = 8개 ->[3,8]
*/
