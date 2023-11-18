import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {//[BOJ_16987]계란으로계란치기 jaehwan solved - dfs 사용
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] durability;
    static int[] weight;
    static int max=-1;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        durability=new int[N];
        weight=new int[N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            durability[i]=Integer.parseInt(st.nextToken());
            weight[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(max);
    }

    static void dfs(int idx, int cnt) {
        // 마지막 계란까지 다 들어봤으면 종료
        if(idx == N) {
            // 최댓값 갱신
            max = Math.max(max, cnt);
            return;
        }
        // 손으로 든 계란이 이미 깨졌거나 모든 계란이 이미 다 깨져 있다면
        if(durability[idx] <= 0 || cnt == N-1) {
            // 다음 계란을 들어 봄
            dfs(idx + 1, cnt);
            return;
        }
        // 다른 계란들과 모두 부딪혀봄
        int nCnt = cnt;
        for(int i=0; i<N; i++) {
            // 손으로 들고 있는 계란과 부딪히려고 하는 계란이 같은 계란이라면 통과
            if(i == idx) continue;
            // 부딪혀 보려고 하는 계란이 이미 깨져있다면 통과
            if(durability[i] <= 0) continue;
            // 계란끼리 부딪혀봄 (현재 손에 들고 있는 계란의 인덱스, 부딪혀보려는 타겟 계란 인덱스)
            hitEgg(idx, i);
            // 부딪혀 봤는데 손에 든 계란이 깨지면 cnt++
            if(durability[idx] <= 0) {
                cnt++;
            }
            // 부딪혀 봤는데 타겟이 된 계란이 깨지면 cnt++
            if(durability[i] <= 0) {
                cnt++;
            }
            // 재귀 호출 -> 다음 계란 들어 봄
            dfs(idx + 1, cnt);
            // for문의 다음 i를 위해 값을 원상복구 해 줌
            recoveryEgg(idx, i);
            cnt = nCnt;
        }
    }
    // 계란끼리 부딪혀보는 메소드
    static void hitEgg(int handEgg, int targetEgg) {
        durability[targetEgg] -= weight[handEgg];
        durability[handEgg] -= weight[targetEgg];
    }

    // 다시 원상복구 하는 메소드
    static void recoveryEgg(int handEgg, int targetEgg) {
        durability[targetEgg] += weight[handEgg];
        durability[handEgg] += weight[targetEgg];
    }
}
/*
백트래킹 문제
dfs를 사용하다가 조건에 맞지 않으면 그즉시 중단하고 이전으로 돌아가 다시 확인하며 가지치기 하는 알고리즘
*/
