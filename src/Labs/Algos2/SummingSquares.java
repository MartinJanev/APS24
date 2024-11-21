package Labs.Algos2;

import java.util.Scanner;

public class SummingSquares {


    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        // Start building up the solution iteratively
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int X = input.nextInt();
        int result = numSquares(X);
        System.out.println(result);
    }
}
