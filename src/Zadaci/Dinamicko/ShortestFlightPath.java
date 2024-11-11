package Zadaci.Dinamicko;

import java.util.Scanner;

public class ShortestFlightPath {
    public static int bestCost(int airportTax[], int[][] cost, int n) {
        int[] best = new int[n];
        best[0] = airportTax[0];

        //presmetka za sekoj grad (vrti j)

        for (int j = 1; j < n; j++) {//gradot za koj sto barame cena
            int min = Integer.MAX_VALUE;

            //svrti gi prethodite resenija (i-ovci)
            for (int i = 0; i < j; i++) { //gradot od koj sto imame cena od prethodno
                int cena = best[i] + cost[i][j] + airportTax[j]; //najdobra cena od prethodno + cena od toj do segasniot grad + taksa na segasniot grad
                min = Math.min(min, cena); //ako e pomala od min, min = cena - dali cenata da otideme od sosedniot grad do j e pomala od min,t.e mozebi nekoj pred prethodnikot
            }

            //sme gi svtele site mozni opcii. Najdena e najniskata cena
            best[j] = min;
        }
        return best[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int[] tax = new int[cities];
        int[][] price = new int[cities][cities];

        for (int i = 0; i < cities; i++) {
            tax[i] = sc.nextInt();
            for (int j = 0; j < cities; j++) {
                price[i][j] = sc.nextInt();
            }
        }
        System.out.println(bestCost(tax, price, cities));

    }
}