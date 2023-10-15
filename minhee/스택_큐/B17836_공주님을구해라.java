package minhee.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17836_공주님을구해라 {
    static int N, M, T; //성의 크기(N,M), 저주의 제한 시간
    static int[][] map;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        //map 데이터 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs(1, 1);
        if (answer <= 0 || answer > T) {
            System.out.println("Fail");
        } else System.out.println(answer);

        br.close();
    }

    private static int bfs(int r, int c) {
        boolean[][] isVisit = new boolean[N + 1][M + 1];
        Queue<Info> que = new LinkedList<>();
        int returnValue = -1;

        isVisit[r][c] = true;
        que.add(new Info(r, c, 0, isVisit));

        while (!que.isEmpty()) {
            Info info = que.poll();
            boolean[][] tmpIsVisit = isVisit;

            if (info.count > T) return -1;
            if (isArrival(info.r, info.c)) {
                if (returnValue != -1) return Math.min(returnValue, info.count); //검을 찾아서 부수는 루트가 있다는 의미
                else return info.count;
            }

            if (map[info.r][info.c] == 2) { //검을 발견할 경우
                int toDestinationLength = Math.abs(info.r - N) + Math.abs(info.c - M);
                returnValue = (info.count + toDestinationLength);
                continue;
            }

            //4방향
            for (int i = 0; i < 4; i++) {
                int moveRow = info.r + dx[i];
                int moveColumn = info.c + dy[i];

                if (moveRow <= 0 || moveColumn <= 0 || moveRow > N || moveColumn > M) continue;
                if (!tmpIsVisit[moveRow][moveColumn] && map[moveRow][moveColumn] != 1) {
                    tmpIsVisit[moveRow][moveColumn] = true;
                    que.add(new Info(moveRow, moveColumn, info.count + 1, tmpIsVisit));
                }

            }
        }
        return returnValue;

    }

    private static boolean isArrival(int row, int column) {
        return (row == N && column == M);
    }
}

class Info {
    int r;
    int c;
    int count;
    boolean[][] isVisit;

    public Info(int r, int c, int count, boolean[][] isVisit) {
        this.r = r;
        this.c = c;
        this.count = count;
        this.isVisit = isVisit;
    }
}
