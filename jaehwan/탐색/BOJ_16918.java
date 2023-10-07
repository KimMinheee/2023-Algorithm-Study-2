import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918 {//[BOJ_16918]봄버맨 jaehwan solved - bfs 사용
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] map;
    static Queue<int[]> q =new LinkedList<>();//자표로 보내서 저장
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int R;
    static int C;
    static int N;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map=new char[R][C];
        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                map[i][j]=s.charAt(j);
            }
        }
        for (int i = 2; i <= N; i++) { //시간만큼
            if (i % 2 == 1) {//홀수일때 폭탄위치 큐에 저장
                for (int k = 0; k < R; k++) {
                    for (int j = 0; j < C; j++) {
                        if (map[k][j] == 'O') { //폭탄위치
                            q.add(new int[]{k, j});
                        }
                    }
                }
                for (char[] m : map) { //저장 한다음 나머지 0채움
                    Arrays.fill(m, 'O');
                }
                bfs();
            }
        }

        if (N % 2 == 0) {//목표수가 짝수일때
            for (char[] m : map) {
                Arrays.fill(m, 'O');
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            map[x][y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) { //범위안
                    if (map[nx][ny] == 'O') {
                        map[nx][ny] = '.';
                    }
                }
            }
        }
    }
}
/*반복문을 돌면서 홀수 일떄 짝수일때를 기준으로 계속 표를 갱신한다*/
