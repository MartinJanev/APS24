package Kolokviumski.TieStoSePadnaa;

import java.util.Scanner;

public class wowFactor {

    public static int numDistinct(String s) {
        int n = s.length();
        int[][] dp = new int[3][n + 1]; // 3 rows for "w", "wo", and "wow"

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);

            dp[0][i] = dp[0][i - 1];
            dp[1][i] = dp[1][i - 1];
            dp[2][i] = dp[2][i - 1];

            if (c == 'w') {
                dp[0][i]++; // Increment count of 'w's
                dp[2][i] += dp[1][i - 1]; // Update count of "wow" using "wo"
            } else if (c == 'o') {
                dp[1][i] += dp[0][i - 1]; // Update count of "wo" using "w"
            }
        }

        return dp[2][n]; // The count of "wow" at the end of the string
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(numDistinct(s));
    }
}
