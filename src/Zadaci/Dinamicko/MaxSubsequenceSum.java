package Zadaci.Dinamicko;

import java.util.Scanner;

public class MaxSubsequenceSum {

//O(n)

    public static int maxSubsequenceSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;
    }

// O(nlog2n)

//    public static int maxSubsequenceSum(int[] arr, int n) {
//        return maxSubSum(arr, 0, n - 1);
//    }
//
//    public static int maxSubSum(int[] arr, int l, int r) {
//        if (l == r)
//            if (arr[l] > 0) {
//                return arr[l];
//            } else {
//                return 0;
//            }
//        int m = (l + r) / 2;
//        int maxLSum = maxSubSum(arr, l, m);
//        int maxRSum = maxSubSum(arr, m + 1, r);
//        int maxLBorderSum = 0, lBorderSum = 0;
//        for (int i = m; i >= l; i--) {
//            lBorderSum += arr[i];
//            if (lBorderSum > maxLBorderSum)
//                maxLBorderSum = lBorderSum;
//        }
//        int maxRBorderSum = 0, rBorderSum = 0;
//        for (int i = m + 1; i < r; i++) {
//            rBorderSum += arr[i];
//            if (rBorderSum > maxRBorderSum) {
//                maxRBorderSum = rBorderSum;
//            }
//        }
//        return Math.max(Math.max(maxLSum, maxRSum), maxLBorderSum + maxRBorderSum);
//
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxSubsequenceSum(arr));
    }
}
