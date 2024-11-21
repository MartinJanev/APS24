package Zadaci.Dinamicko.Videa;


public class LIS300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] LIS = new int[nums.length]; // Longest Increasing Subsequence
        int length = 0;

        for (int num : nums) {
            int pos = findInsertPosition(LIS, length, num); // Find the position where the current element should be inserted
            //if we want to print the LIS with the biggest values of elements possible, we can use this:
            LIS[pos] = Math.max(LIS[pos], num);

            if (pos == length) { // If the position is equal to the length of the LIS, we have a new element
                length++;
            }
        }
        //print the LIS - without the zeros
        for (int i = 0; i < length; i++) {
            System.out.print(LIS[i] + " ");
        }
        System.out.println();

        return length;
    }

    private static int findInsertPosition(int[] LIS, int length, int num) {
        int l = 0, r = length;
        while (l < r) {
            int m = (l + r) / 2;
            if (LIS[m] < num) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        //retarted array of 50 elements
        int[] nums2 = {5, 8, 3, 7, 9, 1, 6, 2, 4, 10, 12, 11, 15, 14, 13, 18, 17, 16, 20, 19, 22, 21, 24, 23, 25, 27, 26,
                29, 28, 30, 32, 31, 34, 33, 36, 35, 38, 37, 40, 39, 42, 41, 44, 43, 46, 45, 48, 47, 50, 49};
        System.out.println(lengthOfLIS(nums2));
       // System.out.println(lengthOfLIS(nums));

    }
}

