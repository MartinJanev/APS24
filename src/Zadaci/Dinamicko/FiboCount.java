package Zadaci.Dinamicko;

import java.util.Scanner;

public class FiboCount {
    public static int memo(int P, int K) {
        int[] memo = new int[30];
        memo[0] = 1;
        memo[1] = 1;

        int counter = 0;
        for(int i=2; memo[i-1] <= K; i++)
        {
            memo[i] = memo[i-1] + memo[i-2];

            if (memo[i] >= P && memo[i] <= K)
            {
                counter++;
            }
        }
        return counter;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(memo(p, k));
    }
}
