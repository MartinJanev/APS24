package Kolokviumski;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpecialChoice {

    //    static int solve(int numbers[], int N, int M, int K) {
//        // dp[i][j] ќе го претставува максимумот на сумата за j избрани броеви од првите i броеви
//        int[][] dp = new int[N + 1][K + 1];
//
//        // Инициализација: ако не се избрани броеви, сумата е 0
//        for (int i = 0; i <= N; i++) {
//            for (int j = 0; j <= K; j++) {
//                dp[i][j] = -1;  // -1 означува невалиден случај
//            }
//        }
//        dp[0][0] = 0;  // Почетна вредност за 0 избрани броеви е 0
//
//        // Пополнување на динамичката табела
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= K; j++) {
//                // Ако не го земаме тековниот број
//                if (dp[i - 1][j] != -1) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
//                }
//
//                // Ако го земаме тековниот број
//                if (i > 1 && numbers[i - 1] + numbers[i - 2] <= M) {
//                    if (dp[i - 2][j - 1] != -1) {
//                        dp[i][j] = Math.max(dp[i][j], dp[i - 2][j - 1] + numbers[i - 1]);
//                    }
//                }
//            }
//        }
//
//        // Враќање на максималната сума за точно K избрани броеви
//        return dp[N][K];
//    }
    static int solve(int numbers[], int N, int M, int K) {
        int[][] dp = new int[K + 1][N + 1];

        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                dp[k][i] = dp[k][i - 1]; // Skip the current element

                for (int j = i - 1; j >= 0; j--) {
                    if (j == 0 || numbers[j - 1] + numbers[i - 1] <= M) {
                        dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + numbers[i - 1]);
                        break;
                    }
                }
            }
        }
        return dp[K][N];
    }


    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, M, K);
        System.out.println(res);

        br.close();
    }
}
