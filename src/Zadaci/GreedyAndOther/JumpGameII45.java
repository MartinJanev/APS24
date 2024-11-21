package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class JumpGameII45 {
//    public static int jumpBF(int[] nums) {
//        int n = nums.length;
//        int[] smallestJumps = {Integer.MAX_VALUE};
//
//        backtrack(0, 0, nums, n, smallestJumps);
//        return smallestJumps[0];
//    }
//
//    private static void backtrack(int i, int jumps, int[] nums, int n, int[] smallest) {
//        if (i >= n - 1) {
//            smallest[0] = Math.min(smallest[0], jumps);
//            return;
//        }
//        int maxJump = nums[i];
//        int maxReachable = Math.min(i + maxJump, n - 1);
//        for (int newIndex = maxReachable; newIndex > i; newIndex--) {
//            backtrack(newIndex, jumps + 1, nums, n, smallest);
//        }
//    }

    public static int jump(int[] nums){ //Greedy solution
        int smallest = 0;
        int n = nums.length;
        int end = 0, farthest = 0;

        for (int i=0; i<n-1; i++){ // n-1 because we don't need to jump from the last index
            farthest = Math.max(farthest, i + nums[i]); //find the farthest index we can reach
            if (i == end) { //if we reach the end of the current jump
                smallest++; //jump
                end = farthest; //update the end to the farthest index we can reach
            }
        }
        return smallest;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(jump(nums)); // 2
    }
}
