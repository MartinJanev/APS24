package Zadaci.Dinamicko;

import java.util.Scanner;

public class MaximumProductSubarray152 {

    public static int maxProduct(int[] nums) {
        // Initialize result as the maximum value in nums
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            res = Math.max(res, num);
        }

        int currMin = 1, currMax = 1;

        for (int n : nums) {
            if (n == 0) {
                currMin = 1;
                currMax = 1;
                continue;
            }

            int temp = currMax;

            currMax = Math.max(n * currMax, Math.max(n * currMin, n)); // n * currMax, n * currMin, n
            currMin = Math.min(temp * n, Math.min(n * currMin, n)); // currMax from previous step * n, currMin * n, n

            // Update the result with the maximum found so far
            res = Math.max(res, currMax);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxProduct(nums));
    }
}
