package minhee.시뮬레이션;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16918_봄버맨 {
    static final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int R, C, N;
    static char[][] map;
    static Queue<Integer> bombTimeQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == 'O') {
                    map[i][j] = '0';
                } else {
                    map[i][j] = line.charAt(j);
                }
            }
        }

        int currentTime = 0;
        bombTimeQueue.add(currentTime); //맨 처음 폭탄 세팅

        while (currentTime <= N) {
            if (currentTime <= 1) {
                currentTime++;
                continue;
            } else if (currentTime == bombTimeQueue.peek() + 3) {//3초 지나서 터져야 하는 시점
                int target = bombTimeQueue.poll();
                executeBomb(target);
            } else {
                setBomb(currentTime);
            }
            currentTime++;

        }

        printMap();
    }

    public static void executeBomb(int target) { //map에서 target에 해당하는 지점을 터트린다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == (char) (target + 48)) {
                    for (int idx = 0; idx < 4; idx++) {
                        int mx = i + move[idx][0];
                        int my = j + move[idx][1];
                        if (mx < 0 || my < 0 || mx >= R || my >= C) continue;
                        map[mx][my] = '.';
                    }
                    map[i][j] = '.';
                }
            }
        }
    }

    public static void setBomb(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = (char) (time + 48);
                }
            }
        }
        bombTimeQueue.add(time);
    }

    public static void printMap() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(Character.isDigit(map[i][j])){
                    sb.append('O');
                }
                else sb.append('.');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
