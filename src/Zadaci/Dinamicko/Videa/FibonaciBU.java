package Zadaci.Dinamicko.Videa;

public class FibonaciBU {
    public static long fib(int n) {
        if (n == 0 || n == 1) { // Base case
            return n;
        }
        long dp[] = new long[n + 1];
        dp[0] = 0; // Base case
        dp[1] = 1; // Base case

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; //Add the two previous numbers to get the current number
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(50));
    }
}
