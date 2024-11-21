package Auditoriski.Sorting;

public class InsertionSort {
    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        T key;
        int begin = 0;
        int end = a.length - 1;
        int i;
        for (int index = begin + 1; index <= end; index++) {
            key = a[index];
            i = index - 1;
            while (i >= begin && a[i].compareTo(key) > 0) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
    }
}
