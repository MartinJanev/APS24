package Auditoriski.Sorting;

public class RadixSort {
    public static void radixSort(int[] arr) {
        Integer[] pom = new Integer[arr.length];
        int i, max = arr[0], exp = 1;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        while (max / exp > 0) {
            int bucket[] = new int[10];
            for (i = 0; i < arr.length; i++) {
                bucket[(arr[i] / exp) % 10]++;
            }

            for (i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (i = arr.length - 1; i >= 0; i--) {
                pom[--bucket[(arr[i] / exp) % 10]] = arr[i];
            }
            for (i = 0; i < arr.length; i++) {
                arr[i] = pom[i];
            }
            exp *= 10;
        }
    }
}
