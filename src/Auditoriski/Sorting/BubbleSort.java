package Auditoriski.Sorting;

public class BubbleSort {
    public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
        int begin = 0;
        int end = a.length - 1;
        T temp;
        boolean flipped = false;
        for (int i = end; i >= begin; i--) {
            flipped = false;
            for (int j = 1; j <= i; j++) {
                if (a[j - 1].compareTo(a[j]) > 0) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    flipped = true;
                }
            }
            if (!flipped) {
                break;
            }
        }
    }//druga implementacija - najgolemiot se turka nadesno
}
