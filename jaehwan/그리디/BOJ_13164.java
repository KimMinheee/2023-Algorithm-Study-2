import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13164 {//[BOJ_13164]행복유치원 jaehwan solved
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr=new int[N-1];
        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) { //0부터 체크하는거 주의 
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num - temp;
            temp = num;
        }
        Arrays.sort(arr);
        int answer=0;
        for(int i=0;i<N-K;i++){
            answer += arr[i];
        }
        System.out.println(answer);
        br.close();
    }
}
