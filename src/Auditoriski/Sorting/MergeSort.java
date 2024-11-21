package Auditoriski.Sorting;

public class MergeSort {

    int INF = 1000000;

    //spojuvanje na dve sortirani nizi [l, mid], [mid+1, r]
    //rezultatot e nova sortirana niza
    public static <T extends Comparable<? super T>> void merge(T a[], int l, int mid, int r) {
        int numel = r - l + 1;
        T temp[] = (T[]) new Comparable[a.length];
        int i, j, k = 0;

        i = l;
        j = mid + 1;

        while ((i <= mid) && (j <= r)) {
            if (a[i].compareTo(a[j]) < 0) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= r) {
            temp[k] = a[j];
            j++;
            k++;
        }

        for (k = 0; k < numel; k++) {
            a[l + k] = temp[k];
        }
    }

    public static <T extends Comparable<? super T>> void mergesort(T a[], int l, int r) {
        if (l == r) {
            return;
        }

        int mid = (l + r) / 2;
        mergesort(a, l, mid);
        mergesort(a, mid + 1, r);
        merge(a, l, mid, r);
    }
}
