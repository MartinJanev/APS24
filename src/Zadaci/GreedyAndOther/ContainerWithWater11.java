package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class ContainerWithWater11 {
    public static int maxArea(int[] height) {
        int res = 0, n = height.length, l = 0, r = n - 1;

        while (l<r){
            int area = (r-l)*Math.min(height[l], height[r]);
            res = Math.max(res, area);

            if (height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        System.out.println(maxArea(height));
    }
}
