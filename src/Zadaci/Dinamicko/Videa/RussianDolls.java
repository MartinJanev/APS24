package Zadaci.Dinamicko.Videa;

import java.util.Arrays;

public class RussianDolls {
    public static int binarySearch(int[] dp, int height, int high) {
        int l = 0, r = high;
        while (l < r) {
            int m = (l + r) / 2;
            if (dp[m] < height) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // Sort the envelopes by width and height - a = width, b = height

        int[] dp = new int[envelopes.length];
        int length = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1]; // height of the envelope
            int pos = binarySearch(dp, height, length); // binary search for the position of the height
            dp[pos] = height;

            if (pos == length) { // if the height is greater than the last element in dp
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
