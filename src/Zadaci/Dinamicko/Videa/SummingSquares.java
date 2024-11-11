package Zadaci.Dinamicko.Videa;

import java.util.HashMap;

public class SummingSquares {
//    public static int summingSq(int n, HashMap<Integer, Integer> memo) {
//        if (n == 0) return 0;
//
//        if (memo.containsKey(n)) {
//            return memo.get(n);
//        }
//
//        int minSquares = Integer.MAX_VALUE;
//        for (int i = 1; i <= Math.sqrt(n); i++) {
//            int square = i * i;
//            int numSquares = 1 + summingSq(n - square, memo);
//            if (numSquares < minSquares) {
//                minSquares = numSquares;
//            }
//        }
//        int res = minSquares;
//        memo.put(n, res);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(summingSq(429, new HashMap<>()));
//    }


    public static int numSquares(int n) {
        // Reduced space usage by avoiding use of sqrt calculations in the outer loop
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
        System.out.println(numSquares(229));
    }
}