package Kolokviumski;
//Дадена е низа од N природни броеви и еден број K. Нека броевите се означени од a0 до aN−1. Да ја дефинираме сумата од апсолутни разлики како abs(a1−a0)+abs(a2−a1)+…+abs(aN−1−aN−2). Да се изберат точно K броеви од низата, така што кога ќе се спојат во една низа, сумата од апсолутни разлики е максимална. Да се испечати оваа сума.
//
//Влез: Во првата линија ви се дадени два броеви N (1≤N≤100) и K (1≤K≤100, K≤N). Во втората линија ви се дадени N позитивни природни броеви, секој од броевите е помал од 1,000.
//
//Излез: Да се испечати бараната максималната сума од апсолутни разлики.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumAbsDiff {

    static int solve(int numbers[], int N, int K) {
        int dp[][] = new int[N][K + 1];
        int i, j, k;



        for (i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + Math.abs(numbers[i] - numbers[i - 1]);
        }

        for (i = 2; i < N; i++) {
            for (j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j - 1];
                for (k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + Math.abs(numbers[i] - numbers[k]));
                }
            }
        }

        int res = 0;
        for (i = 0; i < N; i++) {
            res = Math.max(res, dp[i][K]);
        }

        return res;
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

