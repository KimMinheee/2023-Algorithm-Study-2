import java.util.*;

public class Solution {//[PGM-12980]점프와순간이동 jaehwan solved
    public int solution(int n) {
        int answer=n;
        int energy=0;

        while (answer != 0 ){
            if(answer % 2==1){
                energy++;
            }
            answer/=2;
        }

        return energy;
    }
}
//결국 계산을 해보면 +1씩 만 이동하지 여러칸을 뛰어서는 안된다 끝에서 부터 짝수홀수를 판단하며 /2를 해서 계산
