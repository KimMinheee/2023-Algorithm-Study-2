import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {//[BOJ_7576]토마토 jaehwan solved - bfs 사용
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M;//가로
    static int N;//세로
    static int[][] box;
    static int ans=0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> q=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        box=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                box[i][j]=Integer.parseInt(st.nextToken());
                if(box[i][j]==1) q.add(new Node(i,j));
            }
        }
        System.out.println(bfs());
    }
    public static int bfs() {
        while(!q.isEmpty()){
            Node n=q.poll();

            for(int i=0;i<4;i++){
                int newX=n.x+dx[i];
                int newY=n.y+dy[i];
                if(newX>=0 && newY>=0 &&newX<N &&newY<M){//범위안인거 확인
                    if(box[newX][newY]==0){
                        q.add(new Node(newX,newY));
                        box[newX][newY]=box[n.x][n.y]+1;
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                    if(box[i][j]==0){
                        return -1;
                    }
                    ans=Math.max(ans,box[i][j]);
            }
        }
        if(ans==1){//다익은상태
            return 0;
        }
        else return ans-1;
    }

    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
