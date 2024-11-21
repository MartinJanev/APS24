package Zadaci.Dinamicko;

import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {
    //BU
    public static int calculateMaxPriceBU(int[] prices) {
        int n = prices.length - 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <=j; i++) {
                min = Math.min(min, prices[i] - dp[j - i]);
            }
            dp[j] = min;
        }
        return dp[n];
    }

    //TD
    public static int calculateMaxPriceTD(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return pomosnaTD(prices, n, dp);
    }

    public static int pomosnaTD(int[] prices, int n, int[] dp) {
        if (dp[n] >= 0) {
            return dp[n];
        }
        int solution;
        if (n == 0) {
            solution = 0;
        } else {
            solution = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                int resenie = prices[i] + pomosnaTD(prices, n - i, dp);
                solution = Math.max(solution, resenie);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        //System.out.println(calculateMaxPriceTD(prices));
        System.out.println(calculateMaxPriceBU(prices));
    }
}
