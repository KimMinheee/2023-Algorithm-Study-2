package rudgusee.DFS_BFS;

import java.util.*;

public class BOJ_16987 {
    static int n, max = Integer.MIN_VALUE;
    static int[] durability, weight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        durability = new int[n];
        weight = new int[n];

        // 내구성과 무게 저장
        for (int i = 0; i < n; i++) {
            durability[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        backtracking(0);
        System.out.println(max);
    }

    static void backtracking(int depth) {
        // 마지막 계란인 경우
        if (depth == n) {
            int count = 0;
            // 내구성이 0 이하라면 깨진 계란이기 때문에 깨진 계란의 수를 count
            for (int i = 0; i < n; i++)
                if (durability[i] <= 0)
                    count++;

            max = Math.max(max, count); // 최댓값 구하기
            return;
        }

        // depth번째 계란의 내구성이 0이하라면 다음으로 넘어간다.
        if (durability[depth] <= 0)
            backtracking(depth + 1);

        else {
            boolean broken = false; // 깰 계란이 있는지 확인하는 변수
            // depth번째 계란으로 다른 계란들을 모두 쳐본다.
            for (int i = 0; i < n; i++) {
                // 같은 계란이거나 내구성이 0 이하인 경우는 깰 수 없다.
                if (i == depth || durability[i] <= 0)
                    continue;
                broken = true; // 깰 계란이 있음
                // 두 계란의 내구성 감소
                durability[i] -= weight[depth];
                durability[depth] -= weight[i];
                backtracking(depth + 1);
                // 다음 경우의 수를 위해 값 되돌리기
                durability[i] += weight[depth];
                durability[depth] += weight[i];
            }
            // 깰 계란이 없는 경우 다음으로 넘어간다.
            if (broken == false)
                backtracking(depth + 1);
        }
    }
}
