import java.util.Scanner;

public class BOJ_2748 {//[BOJ_2748]피보나치2 solved - DP 사용 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr=new long[n+1];

        arr[0]=0;
        arr[1]=1;
       if(n == 0) {
           System.out.println("0");
       }
       else if(n>=1){
           for (int i = 2; i <= n; i++) {
               arr[i] = arr[i - 1] + arr[i - 2];
           }
           System.out.println(arr[n]);
       }
    }
}
