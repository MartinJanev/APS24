package Labs.Kolokvium1.Algos1;

import java.util.Scanner;

public class Lamps {

    public static int numLightsNeeded(int[] niza, int streetLength) {
        int brojac = 0; // Count of lamps placed
        int pozicija = 0; // Current position
        int lastLit = -1; // Last lit position

        while (pozicija < streetLength) {
            // Find the farthest position we can place a lamp that lights the current position
            int nextLamp = -1;

            int startI = Math.min(pozicija + 2, streetLength - 1);
            for (int i = startI; i >= pozicija - 2; i--) {
                if (niza[i] == 1) {
                    nextLamp = i;
                    break;
                }
            }

            if (nextLamp == -1) {
                // If no lamp can light the current position, return -1 (not possible to light the street)
                return -1;
            }

            // Place a lamp at the position of `nextLamp`
            brojac++;
            lastLit = nextLamp + 2; // Update last lit position (nextLamp covers 2 positions to the right)
            pozicija = lastLit + 1; // Move to the first unlit position
        }

        return brojac;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of possible lamp positions
        int M = scanner.nextInt(); // Length of the street

        int index;
        int[] niza = new int[M];
        for (int i = 0; i < N; i++) {
            index = scanner.nextInt();
            niza[index - 1] = 1; // Mark valid lamp positions
        }

        System.out.println(numLightsNeeded(niza, M));
    }
}
