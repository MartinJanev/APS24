package Zadaci.Dinamicko;

import java.util.Scanner;

public class TicketQueuing {

    public static void printPairs(int i, long[] c) {
        if (i < 2) return;
        if (c[i] == 1) {
            printPairs(i - 2, c);
            System.out.print("Se spojuvaat " + (i - 1) + " i " + i);
        } else {
            printPairs(i - 1, c);
        }
    }

    public static long[] calculateDP(int n, long[] t, long[] p, long[] c) {
        long[] dp = new long[n + 1];
        dp[0] = 0; //We don't need to serve the 0-th customer
        dp[1] = t[1]; //We need to serve the 1-st customer
        c[1] = 0; // The 1-st customer is served alone

        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] + t[i] > dp[i - 2] + p[i - 1]) { //If it's better to serve the i-th customer with the previous one
                dp[i] = dp[i - 2] + p[i - 1];
                c[i] = 1;
            } else { //If it's better to serve the i-th customer alone
                dp[i] = dp[i - 1] + t[i];
                c[i] = 0;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] t = new long[n + 1]; //Time needed to serve the i-th customer
        long[] p = new long[n]; //Time needed to serve the i-th customer after serving the previous one

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        long[] c = new long[n + 1]; //0 if the i-th customer is served alone, 1 if the i-th customer is served with the previous one
        long[] dp = calculateDP(n, t, p, c);
        System.out.println(dp[n - 1]);
        printPairs(n, c);
    }
}
