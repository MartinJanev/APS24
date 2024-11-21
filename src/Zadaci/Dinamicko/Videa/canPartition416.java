package Zadaci.Dinamicko.Videa;

import java.util.Scanner;

public class canPartition416 {
    public static boolean canPartition(int[] nums) {
        /*
        n+1 - s+1
        ******
        *00000
        *00000
        *00000
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {//site mozni sumi od 0 do s/2
                //bez elementot
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                //so elementot
                /*
                problem e ako j< nums[i-1]
                mozno e ako j>=nums[i-1]
                provruvame dali moze j-nums[i-1] moze da se sozdade
                moze da se dodade vo sumata da se sozdade j
                 */
                if (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum / 2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean res = canPartition(nums);
        if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
