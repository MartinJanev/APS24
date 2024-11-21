package Zadaci.Dinamicko;

public class BinomialCoefficients118 {
    //tezok grev ako ja runnuvas ovaa funkcija

//      public static long binomail(int n, int k) {
//        if (k==0)
//            return 1;
//        if (n==0){
//            return 0;
//
//        }
//        return binomail(n - 1, k - 1) + binomail(n - 1, k)
//}

    public static int binomial(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args){
        System.out.println(binomial(5,2));
    }
}
