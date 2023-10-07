package rudgusee.DFS_BFS;

public class PGM_round {
    public int solution(int n, int a, int b) {

        int answer = 0;
        
        //a, b는 항상이긴다고 가정
        //토너먼트이므로 두팀씩 대결해 다음라운드로 올라가는 팀은 절반으로 줄고 순서도 바뀐다
        while(a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        PGM_round pgmRound = new PGM_round();
        System.out.println(pgmRound.solution(8,4,7));
    }
}
