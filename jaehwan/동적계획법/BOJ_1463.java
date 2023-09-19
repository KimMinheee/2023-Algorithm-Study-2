import java.util.Scanner;

public class BOJ_1463 {//[BOJ_1463]1로만들기 jaehwan solved - dp 사용 
    static int N;
    static int[] D; //연상 횟수 배열
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();

        D=new int[N+1];

        D[0]=0;
        D[1]=0;
        for(int i=2;i<=N;i++){ //배열에 있는 수 들을 쭉 채워나감
            D[i]=D[i-1]+1;
            if(i%2==0){D[i]=Math.min(D[i], D[i/2]+1);}
            if(i%3==0){D[i]=Math.min(D[i], D[i/3]+1);}
        }
        /*
        D[10]이라고하면 D[9]까지 이미 해결된 문제라 가정하고 점화식 세우기
        D[10] = D[9]+1 (연산을 한번 더한 개념)
        D[10]= 10 % 2 +1
        */
        System.out.println(D[N]);
    }
}
/*
1=0
2=1
3=1
4=2
5=3
6=2
7=3
8=3
9=2
10=3

* */
