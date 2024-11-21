package Labs.Algos2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxProductDP {

    public static long findMaxProduct(int[] a) {
        int N = a.length;
        int[] memo = new int[N];
        for (int i = 0; i < N; i++)
            memo[i] = a[i];
        int max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++)
                if (a[i] > a[j] && memo[i] < memo[j] * a[i])
                    //ako e rastecka i novoto resenie e pogolemo od dp
                    memo[i] = memo[j] * a[i];
        }

        for (int i = 0; i < N; i++)
            if (max < memo[i])
                max = memo[i];

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
        System.out.println(findMaxProduct(arr));
    }

}