package Kolokviumski.PrvKolokvium;

//Дадена е низа од N позитивни природни броеви и еден број K. Да се изберат точно K броеви од низата, така што кога ќе се спојат во една низа, следната сума:
//
//1⋅првиотброј+2⋅вториотброј+…+K⋅K−тиотброј
//
//е максимална. Да се испечати оваа сума.
//
//Влез: Во првата линија ви се дадени два броеви N (1≤N≤100) и K (1≤K≤100, K≤N). Во втората линија ви се дадени N позитивни природни броеви, секој од броевите е помал од 1,000.
//
//Излез: Да се испечати бараната максимална тежинска сума.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//10 3
//1 9 2 3 6 1 3 2 1 3
//Output: 42

//5 3
//10 20 30 40 50
//Output: 260

public class WeightedSum {

//    static int solve(int a[], int N, int K) {
//        //DP solution
//        int[][] dp = new int[N + 1][K + 1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= K; j++) {
//                //If we include this element
//                dp[i][j] = dp[i - 1][j];
//                for (int x = 0; x < i; x++) {
//                    int taken = dp[x][j - 1] + j * a[i - 1];
//                    dp[i][j] = Math.max(dp[i][j], taken);
//                }
//            }
//        }
//        return dp[N][K];
//    }

    static int solve(int numbers[], int N, int K) {
        int[][] dp = new int[K + 1][N + 1];

        // Base case: if no elements are chosen, the sum is 0
        for (int i = 0; i <= N; i++) dp[0][i] = 0;

        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                // Option 1: Skip the current element
                dp[k][i] = dp[k][i - 1];

                // Option 2: Include the current element
                dp[k][i] = Math.max(dp[k][i], dp[k - 1][i - 1] + k * numbers[i - 1]);
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) throws Exception {
        int i;

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
