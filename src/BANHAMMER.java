import Zadaci.Dinamicko.KnapsackDinamicko;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BANHAMMER {

//    static long stepen(int n, int k) {
//        if (k == 0) return 1;
//        else return n * stepen(n, k - 1);
//    }

//    static long stepen(int n, int k) {
//        if (k == 0) return 1;
//        else if (k % 2 == 0) {
//            return stepen(n * n, k / 2);
//        } else
//        {
//            return n * stepen(n*n, (k - 1)/2);
//        }
//    }


//    static long stepen(int n, int k) {
//        if (k == 0) return 1;
//        else if (k % 2 == 0) {
//            return stepen(n, k / 2) * stepen(n, k / 2);
//        } else {
//            return n * stepen(n * n, (k - 1) / 2) * stepen(n * n, (k - 1) / 2);
//        }
//    }


    public static void main(String[] args) {
        int[] weight = {10, 7, 4, 2};
        int[] profit = {60, 28, 20, 24};
        int C = 11;
        float res = KnapsackDinamicko.knapsack(C,weight,profit);
        System.out.println(res);
    }

    public static class ShortestSubarraySumK862 {
        //Array Deque implementation
    //    public static int shortestSubarray(int[] nums, int k) {
    //        int n = nums.length;
    //        long[] sum = new long[n + 1];
    //        for (int i = 0; i < n; i++) {
    //            sum[i + 1] = sum[i] + nums[i];
    //        }
    //
    //        int[] q = new int[n + 1];
    //        int l = 0, r = 0, ans = n + 1;
    //        for (int i = 0; i < sum.length; i++) {
    //            while (l < r && sum[i] >= sum[q[l]] + k) {
    //                ans = Math.min(ans, i - q[l++]);
    //            }
    //            while (l < r && sum[i] <= sum[q[r - 1]]) {
    //                r--;
    //            }
    //            q[r++] = i;
    //        }
    //        if (ans <= n) {
    //            return ans;
    //        } else {
    //            return -1;
    //        }
    //    }

        //Deque LinkedList implementation
        public static int shortestSubarray(int[] nums, int minimalSum) {
            int n = nums.length;
            long[] prefix = new long[n + 1];

            // Step 1: Compute prefix sums
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }

            Deque<Integer> deque = new LinkedList<>();
            int minLength = Integer.MAX_VALUE;

            // Step 2: Process prefix sums
            for (int i = 0; i <= n; i++) {
                while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= minimalSum) {
                    minLength = Math.min(minLength, i - deque.pollFirst());
                }

                while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                    deque.pollLast();
                }

                deque.addLast(i);
            }

            return minLength == Integer.MAX_VALUE ? -1 : minLength;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(shortestSubarray(nums, k));
        }
    }
}
