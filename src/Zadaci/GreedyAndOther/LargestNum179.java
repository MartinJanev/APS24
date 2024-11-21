package Zadaci.GreedyAndOther;

import java.util.Arrays;
import java.util.Scanner;

public class LargestNum179 {
    public static String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to sort based on concatenated order
        // If a + b > b + a, then a should come before b
        // If b + a > a + b, then b should come before a
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is 0, return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the result
        String result = new String();
        for (String strNum : strNums) {
            result += strNum;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(largestNumber(nums));
    }
}
