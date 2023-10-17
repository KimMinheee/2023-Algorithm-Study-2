package programmers;

public class k진수에서소수구하기 {//[PGM-92335]k진수에서소수구하기 jaehwan solved
    public static void main(String[] args) {
        Solution s=new Solution();
        long k=s.solution(110011,10);
        System.out.println(k);
    }
    static class Solution {
        public int solution(int n, int k) {//정수, k진수

            int count=0;
            String answer=Integer.toString(n,k);

            String save="";
            boolean prime;
            for(int i=0;i<answer.length();i++){
                if(answer.charAt(i) != '0'){
                    save+=answer.charAt(i);
                }
                else {//0이 붙어있는 경우 따로 처리 필요
                    prime = prime(Long.parseLong(save));
                    if(prime == true){//소수o
                        count++;
                        save="0";
                    }else { //소수 x
                        save="0";
                    }
                }
            }
            if(!save.equals("")){prime = prime(Long.parseLong(save));
                if(prime == true){//소수o
                    count++;
                }
            }
            return count;
        }
        public static boolean prime(long num){
            if (num == 1||num==0) {
                return false;
            }
            for (int i = 2; i <= (int)Math.sqrt(num); i++) { //시간 단축안해주면 시간초과난다
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
