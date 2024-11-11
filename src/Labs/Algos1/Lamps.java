package Labs.Algos1;

import java.util.Scanner;

public class Lamps {

    public static int numLightsNeeded(int[] niza, int streetLength) {

        int brojac = 0, pozicija = 2;
        while (pozicija < streetLength) {
            if (niza[pozicija] == 1) {
                brojac++;
                if (pozicija + 5 > streetLength && pozicija != streetLength - 1) {
                    pozicija = streetLength - 1;
                } else {
                    pozicija += 5;
                }

            } else {
                pozicija--;
            }
        }

        return brojac;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //broj na svetilki
        int M = scanner.nextInt(); //dolzina na ulica

        int index;
        int[] niza = new int[M];
        for (int i = 0; i < N; i++) {
            index = scanner.nextInt();
            niza[index] = 1;
        }

        for (int i = 0; i < M; i++) {
            System.out.print(niza[i] + " ");
        }

        System.out.println();
        System.out.println(numLightsNeeded(niza, M));
    }
}

