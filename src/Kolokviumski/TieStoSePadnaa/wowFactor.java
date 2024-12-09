package Kolokviumski.TieStoSePadnaa;

import java.util.Scanner;

public class wowFactor {
//    public static int numDistinct(String s) {
//        String wowFactor = "wow";
//        int m = s.length(), n = wowFactor.length();
//        int dp[][] = new int[m + 1][n + 1];
//        // dp[i][j] represents the number of distinct subsequences of s[0, i)
//        // which equals to wowFactor[0, j)
//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = 1; //this means that the empty string is a subsequence of any string
//        } // base case
//        for (int i = 1; i <= m; i++) {
//            for (int wowIndex = 1; wowIndex <= n; wowIndex++) {
//                if (s.charAt(i - 1) == wowFactor.charAt(wowIndex - 1)) //if the characters match
//                    dp[i][wowIndex] = dp[i - 1][wowIndex - 1] + dp[i - 1][wowIndex];
//                //add the number of subsequences that end with the previous character
//                else
//                    dp[i][wowIndex] = dp[i - 1][wowIndex];
//                //if the characters don't match, the number of subsequences is the same as the previous character
//            }
//        }
//        return dp[m][n];
//    }

    public static int numDistinct(String s) {
        int n = s.length();
        int wCounterL = 0, wCounterR = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'w') {
                wCounterR++;
            }
        }
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'o') {
                wCounterR -= wCounterL;
                start = i;
                break;
            }
            wCounterL++;
        }

        if (start == -1 || wCounterL == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (start == n) {
                break;
            }
            if (s.charAt(start) == 'o') {
                dp[i] = wCounterR * wCounterL + dp[start - 1];
                start++;
            } else {
                wCounterL++;
                wCounterR--;
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(numDistinct(s));
//        while (sc.hasNext()) {
//            String s = sc.nextLine();
//            System.out.println(numDistinct(s));
//        }
    }
}

