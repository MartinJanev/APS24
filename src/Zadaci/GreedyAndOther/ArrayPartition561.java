//Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such
// that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
package Zadaci.GreedyAndOther;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPartition561 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(arrayPairSum(nums));
    }
}
