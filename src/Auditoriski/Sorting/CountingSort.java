package Auditoriski.Sorting;

public class CountingSort {
    public static void countingSort(Integer[] arr, int k) {
        int i, j;
        Integer[] b = new Integer[k + 1];
        Integer[] c = new Integer[arr.length];

        for (i = 0; i <= k; i++) {
            c[i] = 0;
        }
        for (j = 0; j <= arr.length; j++) {
            c[arr[j]]++;
        }
        for (i = 1; i <= k; i++) {
            c[i] += c[i - 1];
        }
        for (j = arr.length - 1; j >= 0; j--) {
            b[c[arr[j]] - 1] = arr[j];
            c[arr[j]]--;
        }
        for (j = 0; j < arr.length; j++) {
            arr[j] = b[j];
        }
    }
}
