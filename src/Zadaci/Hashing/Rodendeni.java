package Zadaci.Hashing;

import java.util.HashMap;
import java.util.Scanner;


public class Rodendeni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> mapa = new HashMap<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] dati = line.split("\\.");
            int mesec = Integer.parseInt(dati[1]);
            if (mapa.containsKey(mesec)) mapa.put(mesec, mapa.get(mesec) + 1);
            else mapa.put(mesec, 1);
        }

        int mesec = sc.nextInt();
        System.out.println(mapa.get(mesec));
    }
}
