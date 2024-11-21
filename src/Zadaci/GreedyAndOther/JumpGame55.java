package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class JumpGame55 {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1; //the goal is to go to the last index
        for (int i = n - 2; i >= 0; i--) { //start before the last index
            if (i + nums[i] >= goal) {//if we can reach the goal from the current index
                goal = i; //update the goal to the current index
            }
        }
        //if we can reach the first index
        //then we know if we go from the first index to the goal index
        //we can reach the last index
        return goal == 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(canJump(nums)); // true
    }
}