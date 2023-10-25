package programmers;

public class n진수게임 {//[PGM_17687]n진수 jaehwan solved
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.solution(16,16,2,2));

    }
    static class Solution {
        public String solution(int n, int t, int m, int p) {//진수,구할숫자개수(한자리씩),인원,순서
            String answer = "";
            String sumString="";
            int max= t*m;
            for(int i=0;i<max;i++){//진수를 전부 더한 거대한 string생성
                sumString += Integer.toString(i,n).toUpperCase();
            }
            for(int i=p-1;i<max;i+=m){
                answer += sumString.charAt(i);
            }
            return answer;
        }
    }
}
