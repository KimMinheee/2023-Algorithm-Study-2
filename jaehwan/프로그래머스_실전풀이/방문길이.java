class 방문길이 { //[PGM-49994]방문길이 jaehwan solved
    public int solution(String dirs) {
            int answer = 0;
            int[] dx = {-1, 0, 1, 0}; // 'U', 'D', 'R', 'L
            int[] dy = {0, -1, 0, 1};
            boolean[][][][] visit = new boolean[11][11][11][11];
            int x = 5;
            int y = 5;
            for (int i = 0; i < dirs.length(); i++) {
                char direction = dirs.charAt(i);
                int plus = 0;
                if (direction == 'U') {
                    plus = 0;
                } else if (direction == 'L') {
                    plus = 3;
                } else if (direction == 'D') {
                    plus = 2;
                } else if (direction == 'R') {
                    plus = 1;
                }
                //첫 번째 차원: 현재 x 좌표 (x)
                //두 번째 차원: 현재 y 좌표 (y)
                //세 번째 차원: 다음 x 좌표 (ax)
                //네 번째 차원: 다음 y 좌표 (ay)
                int ax = x + dx[plus];
                int ay = y + dy[plus];
                if (ax < 0 || ay < 0 || ax >= 11 || ay >= 11) {
                    continue;
                }
                if (!visit[x][y][ax][ay] && !visit[ax][ay][x][y]) {
                    visit[x][y][ax][ay] = true;
                    visit[ax][ay][x][y] = true;
                    answer++;
                }
                x = ax;
                y = ay;
            }
            return answer;
    }
}
