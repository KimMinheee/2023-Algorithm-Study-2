import java.util.*;

public class Solution {//[점프와순간이동] jaehwan solved
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
