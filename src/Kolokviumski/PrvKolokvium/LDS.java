package Kolokviumski.PrvKolokvium;

import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];

        // to maintain the overall LDS of the array
        int overallMaxLDS = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            // this will calculate the length of maximum LDS upto ith element
            // do for each element in subarray arr[0..i-1]
            for (int j = 0; j < i; j++) {
                // find the longest decreasing subsequence that ends with arr[j]
                // where arr[j] is more than the current element arr[i]
                if (arr[i] < arr[j]) {
                    if (dp[j] > max)
                        max = dp[j];
                }
            }
            // LDS of ith element is max LDS upto i + 1 (include arr[i] in LDS)
            dp[i] = max + 1;

            // to maintain overall LDS of the array
            if (dp[i] > overallMaxLDS)
                overallMaxLDS = dp[i];
        }

        return overallMaxLDS;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
