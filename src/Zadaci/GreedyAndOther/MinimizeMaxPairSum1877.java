package Zadaci.GreedyAndOther;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeMaxPairSum1877 {

    public static int minimizeMaxPairSum(int[] a) {
        //ex: 3 5 4 2 4 6
        Arrays.sort(a);
        int ans = 0;
        int l = 0, r = a.length - 1;
        while (l < r) {
             int par = a[l] + a[r];
            ans = Math.max(ans, par);
            l++;
            r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minimizeMaxPairSum(arr));
    }
}
