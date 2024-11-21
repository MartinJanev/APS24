package Zadaci.GreedyAndOther;

import java.util.Arrays;
import java.util.Scanner;

public class ApplesInBoxes3074 {

    public static int minimumBoxes(int[] apple, int[] capacity) {
        int weight = 0;
        for (int apl : apple) {
            weight += apl;
        }
        Arrays.sort(capacity);
        int boxes = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (weight <= 0) {
                break;
            }
            weight -= capacity[i];
            boxes++;

        }
        return boxes;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] apple = new int[n];
        for (int i = 0; i < n; i++) {
            apple[i] = input.nextInt();
        }
        int m = input.nextInt();
        int[] capacity = new int[m];
        for (int i = 0; i < m; i++) {
            capacity[i] = input.nextInt();
        }

        System.out.println(minimumBoxes(apple, capacity));
    }
}
