//We are given N trains. Write an algorithm that finds the minimum number of platforms needed to schedule those trains.
//
//Input: The first number in the input is the number of trains N, then in the next N lines are the arrival and departure minutes for each of the trains.
//
//Output: The minimum number of needed platforms to accommodate the trains.

package Labs.Kolokvium1.Algos1;

import java.util.Scanner;
import java.util.Arrays;

public class Trains {


    public static int minimumPlatforms(int[] arrivals, int[] departures) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int counter = 1;
        int i = 1, j = 0;
        while (i < arrivals.length && j < departures.length) {
            if (arrivals[i] <= departures[j]) {
                counter++;
                i++;
            } else {
                counter--;
                j++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arrivals = new int[n];
        int[] departures = new int[n];
        for (int i = 0; i < n; i++) {
            arrivals[i] = scanner.nextInt();
            departures[i] = scanner.nextInt();
        }
        System.out.println(minimumPlatforms(arrivals, departures));

    }
}
