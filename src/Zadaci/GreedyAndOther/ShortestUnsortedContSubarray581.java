package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class ShortestUnsortedContSubarray581 {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int end = -1, start = 0;
        int max = nums[0], min = nums[n - 1]; // max and min values of the subarray
        for (int i = 0; i < n; i++) {
            if (max > nums[i]) { //if current is smaller, then the we move the end index
                end = i;
            } else {
                max = nums[i]; //if max is smaller, then we update the max value
            }
            if (min < nums[n - i - 1]) { //if current is bigger, then we move the start index
                start = n - i - 1;
            } else {
                min = nums[n - i - 1]; //if min is bigger, then we update the min value
            }
        }
        //return the length - indexes are the places where the
        //unsorted subarray starts and ends
        return end - start + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findUnsortedSubarray(nums));
    }
}
