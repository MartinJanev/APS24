package Zadaci.Dinamicko.Videa;

public class maxNonAdjacentSum {
    public static void main(String[] args) {
        int[] niz = {2, 4, 5, 12, 7};
        int[] memo = new int[niz.length]; // Memoization array
        System.out.println(maxNonAdjacentSum(niz, 0, memo));
    }

    public static int maxNonAdjacentSum(int[] nums, int i, int[] memo) {
        if (i >= nums.length) return 0; // Base case

        if (memo[i] != 0) return memo[i]; // Check if the value is already calculated

        int res = Math.max(
                nums[i] + maxNonAdjacentSum(nums, i + 2, memo),
                maxNonAdjacentSum(nums, i + 1, memo)
        ); // Recursive call of the function, the maximum of the two possible cases (including the current element and excluding it)
        memo[i] = res; // Store the result in the memoization array
        return res;
    }
}
