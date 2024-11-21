package Zadaci.Dinamicko.Videa;

import java.util.Arrays;

public class MinCoinsBU {
    public static int coinChange(int[] coins, int m) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, m + 1); // Fill the array with a value greater than the maximum value of m
        dp[0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) { // Check if the coin can be used
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // Update the value of dp[i] if the current coin or combination of coins is better
                }
            }
        }

        return dp[m] > m ? -1 : dp[m]; // If the value of dp[m] is greater than m, return -1
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }
}
