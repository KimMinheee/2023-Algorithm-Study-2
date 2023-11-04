import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {//[BOJ_16953]A->B jaehwan solved
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int end= Integer.parseInt(st.nextToken());
        int answer=1;
        while(n != end){
            if(end < n){
                answer=-1;
                break;
            }
            String s=String.valueOf(end);
            if(s.charAt(s.length()-1)!='1' &&end%2!=0){
                answer=-1;
                break;
            }

            if(end%2==0){
                end/=2;
            }else {
                s=s.substring(0,s.length()-1);
                end=Integer.parseInt(s);
            }
            answer++;
        }
        System.out.println(answer);
    }
}
