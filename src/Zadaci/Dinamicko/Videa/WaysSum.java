package Zadaci.Dinamicko.Videa;

public class WaysSum {
    public static int waysSum(int m, int[] coins) {
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(waysSum(254, coins));
    }
}
