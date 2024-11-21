package Kolokviumski;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int solve(int numbers[], int N, int K) {
        int[][] dp = new int[K + 1][N];

        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) dp[1][i] = 0; // Base case: only 1 number chosen

        for (int k = 2; k <= K; k++) {
            for (int i = k - 1; i < N; i++) {
                for (int j = k - 2; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + Math.abs(numbers[i] - numbers[j]));
                }
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = K - 1; i < N; i++) maxSum = Math.max(maxSum, dp[K][i]);
        return maxSum;
    }


    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}
