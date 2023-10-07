package rudgusee.DP1;


class PGM_JumpAndMove {
    public int solution(int n) {
        int ans = 0;

        //이동하려는 거리 N이 주어졌을 때,
        //K 칸을 앞으로 점프하거나, (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동 가능
        //순간이동을 하면 건전지 사용량이 줄지 않지만, 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용량이 듭니다
        //처음 위치 0 에서 1 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 1) x 2에 해당하는
        //위치로 이동할 수 있으므로 위치 2로 이동합니다. 이때 1 칸을 앞으로 점프하면 위치3으로 이동합니다.
        //이때 다시 순간이동 하면 (현재까지 온 거리 : 3) x 2 이동할 수 있으므로 위치 6에 도착합니다.
        //이 경우가 건전지 사용량이 가장 적으므로 2를 반환해주면 됩니다.

        while(n != 0){
            //주어진 N이 0이 될 때까지
            //N이 짝수면 N /= 2 (순간이동)
            //N이 홀수면 N -= 1 (점프) 연산을 반복한다.
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        //사용해야 하는 건전지 사용량의 최솟값
        return ans;
    }

    public static void main(String[] args) {
        PGM_JumpAndMove pgm_jump = new PGM_JumpAndMove();
        System.out.println(pgm_jump.solution(5));
        System.out.println(pgm_jump.solution(6));
        System.out.println( pgm_jump.solution(5000));

    }
}
