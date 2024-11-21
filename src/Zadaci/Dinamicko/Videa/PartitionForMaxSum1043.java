package Zadaci.Dinamicko.Videa;

import java.util.Scanner;

public class PartitionForMaxSum1043 {
    /*
    [1,15,7,9,2,5,10] so k=3, moze da se podeli na:
    [1,15,7,9,2,5][10] best so prefix 6 + 10*1
    [1,15,7,9,2][5,10] best so prefix 5 + max(5,10)*2
    [1,15,7,9][2,5,10] best so prefix 4 + max(2,5,10)*3

    presmetuvanje najdobar odogovr za sekoj prefiks na nizata
    generalno dp[i] = best of chopping 1,2, ili 3 od krajot
    []-0
    prefix so dolzina 0 (base), 1,2,3,...,n
    n+1 prefiksi, dp[1 indeksen]
     */

    public static int calculatePartitions(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= Math.min(i, k); j++) {
                max = Math.max(max, arr[i - j]);
                int opcija = dp[i - j] + max * j;
                dp[i] = Math.max(dp[i], opcija);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println(calculatePartitions(arr, k));
    }
}
