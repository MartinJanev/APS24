package Zadaci.Dinamicko;

import java.util.Scanner;

public class BinomialCoeficientsRow {

    public static void binomialRow(int n){
        int [][] dp = new int[n+1][n+13];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.print(dp[n][i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        binomialRow(n);

    }
}
