package Zadaci.Dinamicko.Videa;

import java.util.Arrays;

public class MinCoinsTD {
    static int[] memo;

    public static int minCoins(int m, int[] coins) {
        if (m == 0) return 0; // Base case
        if (memo[m] != -1) return memo[m]; // Check if the value is already calculated

        int answer = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (m - coin >= 0) {
                int subproblem = m - coin; // Reduce the problem size
                int subResult = minCoins(subproblem, coins);// Recursive call
                if (subResult != Integer.MAX_VALUE) { // If the subproblem is solvable
                    answer = Math.min(answer, 1 + subResult); // Update the answer
                }
            }
        }

        memo[m] = (answer == Integer.MAX_VALUE) ? -1 : answer; // Store the answer in the memo table
        return memo[m];
    }

    public static void main(String[] args) {
        int m = 7;
        int[] coins = {1, 2, 3};
        memo = new int[m + 1];
        Arrays.fill(memo, -1);
        System.out.println(minCoins(m, coins));
    }
}

