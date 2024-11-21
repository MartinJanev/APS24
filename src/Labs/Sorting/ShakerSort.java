package Labs.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {

    static void shakerSort(int a[], int n) {
        int minCounter = 0;
        int maxCounter = 0;
        boolean done = false;
        for (int j = 0; j < (a.length + 1) / 2; ++j) {

            done = true;

            //bubbleSortMin
            for (int i = a.length - 1; i > minCounter; --i) {
                if (a[i] < a[i - 1]) {
                    int temp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temp;
                    done = false;
                }
            }
            ++minCounter;
            write(a);

            //bubbleSortMax
            for (int i = maxCounter; i < a.length - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    done = false;
                }
            }
            ++maxCounter;
            write(a);
            if (done)
                break;
        }
    }

    static void write(int[] a) {
        int i;
        for (i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);
        shakerSort(a, n);
    }
}