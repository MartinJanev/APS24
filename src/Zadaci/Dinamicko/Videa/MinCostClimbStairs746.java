package Zadaci.Dinamicko.Videa;

import java.util.Scanner;

public class MinCostClimbStairs746 {
    public static int minCostClimbingStairs(int[] cost) {

        /*
        za da se dostigne skala n
        1: od n-1 -> iznesuva min da se stigne n-1vata skala + cena[n-1]
        2: od n-2 -> izneduva min da se stigne n-2rata skala + cena[n-2]
         */
        int n = cost.length;
        int[] dp = new int[n + 1];
        //base case
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(
                    dp[i - 1] + cost[i - 1],
                    dp[i - 2] + cost[i - 2]
            );
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        System.out.println(minCostClimbingStairs(cost));
    }
}
