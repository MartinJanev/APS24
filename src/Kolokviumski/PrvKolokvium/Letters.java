package Kolokviumski.PrvKolokvium;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Letters {

//    static int solve(String S, int N, int K) {
//        final int MOD = 1000007;
//        boolean[] isVowel = new boolean[26];
//        for (char c : "aeiou".toCharArray()) isVowel[c - 'a'] = true;
//
//        int[][] dp = new int[N + 1][K + 1];
//        dp[0][0] = 1;
//
//        for (int i = 1; i <= N; i++) {
//            char current = S.charAt(i - 1);
//            boolean currentVowel = isVowel[current - 'a'];
//
//            for (int j = 0; j <= K; j++) {
//                dp[i][j] = dp[i - 1][j]; // Skip current letter
//                if (j > 0 && (i < 2 || !(currentVowel && isVowel[S.charAt(i - 2) - 'a']))) {
//                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD; // Include current letter
//                }
//            }
//        }
//        return dp[N][K];
//    }

    static int solve(String S, int N, int K) {
        final int MOD = 1000007;
        boolean[] isVowel = new boolean[26];
        for (char c : "aeiou".toCharArray()) isVowel[c - 'a'] = true;

        int[][][] dp = new int[N + 1][K + 1][2];

        dp[0][0][0] = 1; // Base case: 0 letters chosen with no vowels

        for (int i = 1; i <= N; i++) {
            char c = S.charAt(i - 1);
            boolean vowel = isVowel[c - 'a'];

            for (int j = 0; j <= K; j++) {
                // Skip the current character
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;

                if (j > 0) {
                    if (vowel) {
                        dp[i][j][1] = dp[i - 1][j - 1][0];
                    } else {
                        dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]) % MOD;
                    }
                }
            }
        }
        return (dp[N][K][0] + dp[N][K][1]) % MOD;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int N = S.length();
        int K = Integer.parseInt(br.readLine());

        int res = solve(S, N, K);
        System.out.println(res);

        br.close();

    }
}

