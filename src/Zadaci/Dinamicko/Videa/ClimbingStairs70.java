package Zadaci.Dinamicko.Videa;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(65));
    }

    public static long climbStairs(int n) {
        /*
        Brojot na nacini da se stigne od prethodnite 2 e fakticni Fibonaci
         */

        if (n == 1) return 1;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
