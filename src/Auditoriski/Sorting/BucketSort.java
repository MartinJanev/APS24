package Auditoriski.Sorting;

import java.util.Arrays;

public class BucketSort {
    public static void bucketSort(int[] arr, int max) {
        Integer[] bucket = new Integer[max + 1];
        Arrays.fill(bucket, 0);
        for (int k : arr) {
            bucket[k]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[index++] = i;
            }
        }
    }
}
