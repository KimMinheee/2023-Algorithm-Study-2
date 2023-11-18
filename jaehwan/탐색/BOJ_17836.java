import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17836 {
    static int n,m,t;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n= sc.nextInt();
        m=sc.nextInt();
        t=sc.nextInt();
        map=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=sc.nextInt();
            }
        }
        visited=new boolean[n][m][2]; //그람 유무
        int answer=bfs(0,0);
        if(answer==1){
            System.out.println("Fail");
        }else {
            System.out.println(answer);
        }
    }
    public static int bfs(int x,int y) {
        Queue<Node_17836> q = new LinkedList<>();
        q.offer(new Node_17836(x, y, 0, false));
        visited[x][y][0] = true;

        while(!q.isEmpty()) {
            Node_17836 current = q.poll();

            if(current.count > t) break;
            if(current.x == n - 1 && current.y == m - 1) return current.count;

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(!current.isGram) { //그람 없음
                        if(!visited[nx][ny][0] && map[nx][ny] == 0) {
                            q.offer(new Node_17836(nx, ny, current.count + 1, current.isGram));
                            visited[nx][ny][0] = true;
                        } else if(!visited[nx][ny][0] && map[nx][ny] == 2) {
                            q.offer(new Node_17836(nx, ny, current.count + 1, true));
                            visited[nx][ny][0] = true;
                        }
                    } else { //그람 있음
                        if(!visited[nx][ny][1]) {
                            q.offer(new Node_17836(nx, ny, current.count + 1, current.isGram));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static class Node_17836 {
        int x;
        int y;
        int count;
        boolean isGram;

        public Node_17836(int x, int y, int count, boolean isGram) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isGram = isGram;
        }
    }
}
