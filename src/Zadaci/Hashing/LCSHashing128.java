package Zadaci.Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class LCSHashing128 {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int count = 0;
        int len = Integer.MIN_VALUE;

        if (nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int num : hashSet) {
            if (!hashSet.contains(num - 1)) {
                count = 1;
                int x = num;
                while (hashSet.contains(x + 1)) {
                    x = x + 1;
                    count += 1;
                }
                len = Math.max(len, count);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(longestConsecutive(nums));
    }
}
