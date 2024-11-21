package Auditoriski.Sorting;

public class QuickSort {
    public static <T extends Comparable<? super T>> void swap(T[] a, int x, int y) {
        T temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static <T extends Comparable<? super T>> void qucikSort(T[] a, int left, int right) {
        int pivot_index = partition(a, left, right);
        if (left < pivot_index - 1) {
            qucikSort(a, left, pivot_index - 1);
        }
        if (pivot_index < right) {
            qucikSort(a, pivot_index, right);
        }
    }

    public static <T extends Comparable<? super T>> int partition(T[] a, int left, int right) {
        int i = left, j = right;
        T pivot = a[(left + right) / 2];
        while (i <= j) {
            while (a[i].compareTo(pivot) < 0) {
                i++;
            }
            while (a[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        return i;
    }
}
