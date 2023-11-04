package minhee.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [그래프]p16918_봄버맨
 */

public class B16918_봄버맨 {
    static int R,C,N;
    static char[][] map;
    static List<Point> bombList = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                char tmp = line.charAt(j);
                map[i][j] = tmp;
                if(tmp == 'O'){
                    bombList.add(new Point(i,j));
                }
            }
        }

        if(N>1) getMap2(2);

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void getMap2(int second){
        while(second <= N){
            if(second %2 == 0){ //초가 짝수일 때 - 폭탄 설치
                for(int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        map[i][j] = 'O'; //폭탄 전부 설치.
                    }
                }
            }
            else if(second %2 != 0){ // 초가 홀수일 때 - 터뜨리기
                for(Point point : bombList){
                    map[point.x][point.y] = '.';
                    for(int i=0; i<4; i++){
                        int mx = point.x + dx[i];
                        int my = point.y + dy[i];

                        if(mx<0 || mx>=R || my<0 || my>=C) continue; //경계 확인

                        //폭탄 인접부분 '.'으로 만들기
                        map[mx][my] = '.';
                    }
                }
                bombList.clear();
                //터트린 후 폭탄 위치
                for(int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        if(map[i][j] == 'O') bombList.add(new Point(i,j));
                    }
                }
            }
            second ++;
        }
    }


}
class Point{
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

}
