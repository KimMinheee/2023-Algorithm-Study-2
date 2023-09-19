import java.util.Scanner;

public class BOJ_2839 {//[BOJ_2839]설탕배달 jaehwan solved 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        final int sugar3 = 3;
        final int sugar5 = 5;
        int answer = -1;
        int max5=n/5; //가장 큰 5의 배수

        if (n % sugar5 == 0) { //5의 배수인가
            answer= n/sugar5;
        } else { //아닌 경우 전부 계산 필요함
            for(int i=max5;i>=0;i--){ //5가 몇개 들어가는지 계산이 필요
                if(((n-i*5)%3) == 0){
                    answer=i+((n-i*5)/3);//5의 개수 + 3의 개수
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
