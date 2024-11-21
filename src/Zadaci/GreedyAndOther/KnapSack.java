package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class KnapSack {
    public static void sort(double[] profit, double[] weight, int n) {
        double relativeProfit[] = new double[profit.length];

        for (int i = 0; i < n; i++) {
            relativeProfit[i] = profit[i] / weight[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (relativeProfit[i] < relativeProfit[j]) {
                    double temp = relativeProfit[i];
                    relativeProfit[i] = relativeProfit[j];
                    relativeProfit[j] = temp;

                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;

                    temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;
                }
            }
        }
    }

    public static float grFractKnp(double p[], double t[], float C, int n, float x[]) {
        sort(p, t, n);
        float profit = 0;
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (C > t[i]) {
                x[i] = 1;
                C -= t[i];
                profit += p[i];
            } else {
                x[i] = (C / (float) t[i]);
                profit += x[i] * (float) p[i];
                C = 0;
                break;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
//        double[] profit = {200, 100, 5, 80};
//        double capacity = 20;
//        double[] weight = {10, 20, 0.5, 5};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float capacity = sc.nextInt();

        double profit[] = new double[n];
        double weight[] = new double[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextDouble();
        }


        System.out.println("Greedy fractional knapsack: " + grFractKnp(profit, weight, capacity, n, new float[profit.length]));
    }


}
