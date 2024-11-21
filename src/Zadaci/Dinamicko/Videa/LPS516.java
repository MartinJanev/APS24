package Zadaci.Dinamicko.Videa;

import java.util.Scanner;

public class LPS516 {
    //Longest Palindromic Subsequence
    static int[][] dp = new int[1000][1000];
    static String str;

    public static int solve(int l, int r) {
        if (l == r + 1) { //ako e prazen
            return 0;
        }
        if (l == r) { //length ==1
            return 1;
        }
        if (dp[l][r] > 0) {
            return dp[l][r];
        }

        if (str.charAt(l) == str.charAt(r)) {
            dp[l][r] = 2 + solve(l + 1, r - 1);
        }
        dp[l][r] = Math.max(dp[l][r], solve(l + 1, r));
        dp[l][r] = Math.max(dp[l][r], solve(l, r - 1));
        return dp[l][r];
    }

    public static int LPS(String s) {
       /*
       bbbab
        se gleda prvata is poslednata bukva
        naogjame za bba itn..
        n^2 podstringovi
        dp[l][r] - resenie na problemot
        podniza od l do r sose niv
        base case
        ""-0
        "x"-1
        */
        str = s;
        return solve(0, s.length() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(LPS(s));
    }
}
