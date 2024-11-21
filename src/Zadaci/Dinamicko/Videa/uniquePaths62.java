package Zadaci.Dinamicko.Videa;

public class uniquePaths62 {
    public static int paths(int n, int m) {
        //moze da se dvizi samo nadolu ili nadesno -> nekoja
        //kelija se stiga ili od nad ili levo od nea
        int[][] memo = new int[n][m];

        // Initialize the base cases
        for (int i = 0; i < n; i++) {
            memo[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            memo[0][j] = 1;
        }

        // Fill the memoization table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1]; // The number of ways to get to (i, j) is the sum of the ways to get to (i - 1, j) and (i, j - 1)
            }
        }

        return memo[n - 1][m - 1];
    }


    public static int pathsIINacin(int m, int n) {
        //moze da se dvizi samo nadolu ili nadesno -> nekoja
        //kelija se stiga ili od nad ili levo od nea
        int[][] memo = new int[m + 1][n + 1];
        memo[1][1] = 1;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if(i==1&&j==1)continue;
                memo[i][j]=memo[i][j-1]+memo[i-1][j];
            }
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        System.out.println(pathsIINacin(18, 6));
    }
}
