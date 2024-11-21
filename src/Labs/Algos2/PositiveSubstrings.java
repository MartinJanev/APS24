package Labs.Algos2;

import java.util.Scanner;

public class PositiveSubstrings {

//    public static int count(String S, int N) {
//        // DP матрица за да се зачува балансот на секој подстринг
//        int[][] dp = new int[N][N];
//
//
//        // Променлива за броење на позитивни подстрингови
//        int positiveSubstringsCount = 0;
//
//        // Пополнување на DP матрицата - горно триаголна матрица
//        for (int i = 0; i < N; i++) {
//            // Иницијализација на почетниот баланс за подстрингот што почнува на индекс i
//            if (S.charAt(i) == '1') {
//                dp[i][i] = 1;
//                positiveSubstringsCount++;
//
//            } else {
//                dp[i][i] = -1;
//            }
//        }
//        for (int i = 0; i < N; i++) {
//            // Пополнување на остатокот од редот за подстрингови што почнуваат на индекс i
//            for (int j = i + 1; j < N; j++) {
//                // Пресметка на балансот за подстрингот од i до j
//                if (S.charAt(j) == '1') {
//                    dp[i][j] = dp[i][j - 1] + 1;
//                } else {
//                    dp[i][j] = dp[i][j - 1] - 1;
//                }
//
//                // Проверка дали овој подстринг е позитивен
//                if (dp[i][j] > 0) {
//                    positiveSubstringsCount++;
//                }
//            }
//        }
//        return positiveSubstringsCount;
//    }


    public static int count(String s, int N) {

        int count = 0;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '1') {
                dp[i][i] = 1;
                count++;
            } else {
                dp[i][i] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(j) == '1') {
                    dp[i][j] = 1 + dp[i][j - 1];
                } else {
                    dp[i][j] = -1 + dp[i][j - 1];
                }
                if (dp[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Вчитување на влезот
        int N = sc.nextInt(); // Должина на бинарниот стринг
        String S = sc.next(); // Бинарниот стринг S


        // Печатење на вкупниот број на позитивни подстрингови
        System.out.println(count(S, N));

        sc.close();
    }
}
