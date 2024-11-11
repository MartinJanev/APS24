package Labs.Algos1;

import java.util.Scanner;

public class ExercisesGreedy {

    public static float maxProfit(int[] times, int[] profit, int C) {
        //greedu algorithm
        int N = times.length;
        float maxProfit = 0;
        int[] relProfit = new int[N];
        for (int i = 0; i < N; i++) {
            relProfit[i] = profit[i] / times[i];
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (relProfit[i] < relProfit[j]) {
                    int temp = relProfit[i];
                    relProfit[i] = relProfit[j];
                    relProfit[j] = temp;
                    temp = times[i];
                    times[i] = times[j];
                    times[j] = temp;
                    temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (C > times[i]) {
                C -= times[i];
                maxProfit += profit[i];
            } else {
                maxProfit += (C / (float) times[i]) * profit[i];
                C = 0;
                break;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = 40;
        int[] times = new int[N];
        int[] profit = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }
        System.out.println((int)maxProfit(times, profit, C));


    }
}
