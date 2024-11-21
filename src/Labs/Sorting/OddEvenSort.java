package Labs.Sorting;

//Given a sequence of N natural numbers. It is necessary to sort the sequence so that in the first part of
// the sequence the odd numbers from it will be sorted in ascending order, and in the second part the
// even numbers will be sorted in descending order.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void sort(int[] arr, boolean ascending) {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if ((ascending && arr[i] > arr[i + 1]) || (!ascending && arr[i] < arr[i + 1])) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        } while (!sorted);
    }

    static void oddEvenSort(int a[], int n) {
        int oddNum = 0, evenNum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) evenNum++;
            else oddNum++;
        }
        int[] odd = new int[oddNum];
        int[] even = new int[evenNum];

        int i, j = 0, k = 0;
        for (i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                even[j++] = a[i];
            } else {
                odd[k++] = a[i];
            }
        }


        sort(odd, true);
        sort(even, false);
        for (i = 0; i < oddNum; i++) {
            a[i] = odd[i];
        }
        for (i = 0; i < evenNum; i++) {
            a[oddNum + i] = even[i];
        }
    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++) {
            a[i] = Integer.parseInt(pom[i]);
        }
        oddEvenSort(a, n);
        for (i = 0; i < n - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(a[i]);
    }
}