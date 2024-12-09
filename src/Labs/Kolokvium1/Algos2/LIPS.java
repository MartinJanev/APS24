package Labs.Kolokvium1.Algos2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LIPS {
    public static int findLIPS(int[] a, int N) {
        int[] dp = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            int max = a[i]; //local maximum

            for (int j = i + 1; j < N; j++) {
                if (a[i] < a[j]) { //if it is increasing
                    int calcWith = a[i] * dp[j]; //result with taking the previous maximal answer
                    max = Math.max(max, calcWith); //max between local and previous max answer
                }
            }
            dp[i] = max; //save it
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        int arr[] = new int[N];
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(pomniza[i]);
        }

        System.out.println(findLIPS(arr, N));
    }

}