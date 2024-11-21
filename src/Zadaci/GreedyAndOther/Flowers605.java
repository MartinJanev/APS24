//You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
//
//Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
//
//
package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class Flowers605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                count++;

                if (count == n) {
                    return true;
                }
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //number of flowers to be placed
        int n = sc.nextInt(); //number of flowerbeds
        int[] flowerbed = new int[n];
        for (int i = 0; i < n; i++) {
            flowerbed[i] = sc.nextInt();
        }

        System.out.println(canPlaceFlowers(flowerbed, M));
    }

}
