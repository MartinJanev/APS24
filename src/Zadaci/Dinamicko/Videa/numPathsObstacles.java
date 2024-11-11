package Zadaci.Dinamicko.Videa;

import java.util.Scanner;

public class numPathsObstacles {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n) {

        // Check if the starting cell or the destination cell is blocked
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // Fill the first column based on obstacles
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == -1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == -1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // Fill the rest with the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] obstacleGrid = new int[m][n];

        //obstacles are represented by -1

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacleGrid[i][j] = sc.nextInt();
            }
        }
        System.out.println(uniquePathsWithObstacles(obstacleGrid, m, n));
    }
}
