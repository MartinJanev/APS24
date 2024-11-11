package Labs.Algos2;

import java.util.Scanner;

public class PositiveSubstringsDQ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input reading
        int N = sc.nextInt(); // Length of the binary string
        String S = sc.next(); // The binary string S

        // Call the divide and conquer function
        int result = countPositiveSubstrings(S, 0, N - 1);

        // Output the result
        System.out.println(result);

        sc.close();
    }

    // Divide and conquer function to count positive substrings
    public static int countPositiveSubstrings(String S, int start, int end) {
        // Base case: Single character
        if (start == end) {
            // A single '1' is a positive substring, a single '0' is not
            return S.charAt(start) == '1' ? 1 : 0;
        }

        // Divide: Split the string into two halves
        int mid = (start + end) / 2;

        // Conquer: Recursively count positive substrings in the left and right halves
        int leftCount = countPositiveSubstrings(S, start, mid);
        int rightCount = countPositiveSubstrings(S, mid + 1, end);

        // Combine: Count positive substrings that cross the boundary
        int crossCount = countCrossPositiveSubstrings(S, start, mid, end);

        // Total positive substrings is the sum of left, right, and cross counts
        return leftCount + rightCount + crossCount;
    }

    // Helper function to count positive substrings that cross the boundary
    public static int countCrossPositiveSubstrings(String S, int start, int mid, int end) {
        int crossCount = 0;

        // Arrays for cumulative balances in the left and right halves
        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        int[] leftBalances = new int[leftSize];
        int[] rightBalances = new int[rightSize];

        // Calculate cumulative balances from the middle towards the start (left half)
        int balance = 0;
        for (int i = mid, k = 0; i >= start; i--, k++) {
            if (S.charAt(i) == '1') {
                balance++;
            } else {
                balance--;
            }
            leftBalances[k] = balance; // Store in reverse order
        }

        // Calculate cumulative balances from the middle+1 towards the end (right half)
        balance = 0;
        for (int j = mid + 1, k = 0; j <= end; j++, k++) {
            if (S.charAt(j) == '1') {
                balance++;
            } else {
                balance--;
            }
            rightBalances[k] = balance;
        }

        // Count positive cross substrings by combining left and right balances
        for (int leftBalance : leftBalances) {
            for (int rightBalance : rightBalances) {
                if (leftBalance + rightBalance > 0) {
                    crossCount++;
                }
            }
        }

        return crossCount;
    }
}
