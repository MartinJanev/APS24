package Zadaci.DivideAndConquer;

public class BucketSort {
    public static void sort(int[] array) {
        //O(n)

        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }

        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] - min]++;
        }

        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                array[k++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
