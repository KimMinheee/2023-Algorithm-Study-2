package minhee.구현;

public class P12980_점프와순간이동 {
    public static int solution(int n) {
        int ans = 0;
        while (n > 0) {
            if (n %2 == 1) {
                ans += 1;
            }
            n /= 2;
        }
        return ans;
    }
}
