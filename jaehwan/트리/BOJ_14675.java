import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14675 { //[BOJ_14675]단절점단절선 jaehwan solved
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b); //양방향
            list[b].add(a);
        }
        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 2) { //모든 간선이 단절선이다 트리는 모든 정점이 연결되어 있다
                System.out.println("yes");
            }else {
                int idx = Integer.parseInt(st.nextToken());
                if(list[idx].size() >=2) //간선이 2개이상이어야함 양방향 주의 <- 리프 노드만 아니면 ok
                    System.out.println("yes");
                else System.out.println("no");
            }
        }
    }
}
