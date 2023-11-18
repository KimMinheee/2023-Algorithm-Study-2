package programmers;

import java.util.Stack;

public class 괄호회전 { //[PGM-76502]괄호회전 jaehwan solved - stack 사용
    public static void main(String[] args) {
        String s="[)(]";
        String p="";
        String[] arr=new String[s.length()];
        int answer = 0;

        for(int i=0;i<s.length();i++){
            arr[i]= String.valueOf(s.charAt(i));
        }
        for(int i=0;i<s.length();i++) {
            if (isValid(arr)) {
                answer++;
            }
            for (int j = 0; j < s.length(); j++) {
                if (j == 0) {
                    p = arr[0]; //임시저장
                }
                if (j != s.length() - 1) {
                    arr[j] = arr[j + 1];
                } else {
                    arr[s.length() - 1] = p;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean isValid(String[] arr) {
        Stack<String> stack = new Stack<>();

        for (String bracket : arr) {
            if (bracket.equals("(") || bracket.equals("{") || bracket.equals("[")) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                String top = stack.pop();
                if (!(top.equals("(") && bracket.equals(")")
                        || top.equals("{") && bracket.equals("}")
                        || top.equals("[") && bracket.equals("]"))) {
                    return false;
                }
            }
        }
        return true;
    }
}
