package Kolokviumski.TieStoSePadnaa;

import java.util.Scanner;

public class wowFactor {
    public static int numDistinct(String s) {
        String wowFactor = "wow";
        int m = s.length(), n = wowFactor.length();
        int dp[][] = new int[m + 1][n + 1];
        // dp[i][j] represents the number of distinct subsequences of s[0, i)
        // which equals to wowFactor[0, j)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; //this means that the empty string is a subsequence of any string
        } // base case
        for (int i = 1; i <= m; i++) {
            for (int wowIndex = 1; wowIndex <= n; wowIndex++) {
                if (s.charAt(i - 1) == wowFactor.charAt(wowIndex - 1)) //if the characters match
                    dp[i][wowIndex] = dp[i - 1][wowIndex - 1] + dp[i - 1][wowIndex];
                //add the number of subsequences that end with the previous character
                else
                    dp[i][wowIndex] = dp[i - 1][wowIndex];
                //if the characters don't match, the number of subsequences is the same as the previous character
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(numDistinct(s));
    }
}

