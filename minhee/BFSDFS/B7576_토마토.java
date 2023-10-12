package minhee.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576_토마토 {
    private static int M, N;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //열 수
        N = Integer.parseInt(st.nextToken()); //행 수

        map = new int[N][M];
        visited = new boolean[N][M];
        List<Point> tomatoList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    tomatoList.add(new Point(i, j));
                }
            }
        }

        int day = find(0, tomatoList);

        if(checkAllTomatoes()) System.out.println(day);
        else System.out.println(-1);
    }

    private static int find(int count, List<Point> tomatoList) {
        Queue<Tomato> queue = new LinkedList<>();
        for (Point point : tomatoList) {
            visited[point.x][point.y] = true;
            queue.add(new Tomato(point, count));
        }
        int value = 0;

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = tomato.point.x + dx[i];
                int my = tomato.point.y + dy[i];

                if(!isInRange(mx,my) || map[mx][my] != 0 || visited[mx][my]) continue;

                visited[mx][my] = true;
                map[mx][my] = tomato.count+1;
                queue.add(new Tomato(new Point(mx,my), tomato.count+1));
            }
            value = Math.max(value,tomato.count);
        }
        return value;
    }

    private static boolean isInRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < M);
    }

    private static boolean checkAllTomatoes(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Tomato {
    Point point;
    int count;

    public Tomato(Point point, int count) {
        this.point = point;
        this.count = count;
    }
}
