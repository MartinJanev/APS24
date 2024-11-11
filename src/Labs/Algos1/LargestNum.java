package Labs.Algos1;

import java.util.Scanner;

public class LargestNum {
    public static void merge(int a[], int l, int mid, int r) {
        int numel = r - l + 1;
        int temp[] = new int[100]; //nova niza za privremeno cuvanje na sortiranite elementi
        int i, j, k = 0; //indeksi vo nizite

        i = l;  //pocetok na prva niza
        j = mid + 1; //pocetok na vtora niza

        while ((i <= mid) && (j <= r)) {//dodeka ne se ispraznat site nizi
            if (a[i] > a[j]) { //sporedba na elementite od dvete nizi
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }

        while (i <= mid) { //ako ima preostanato od prva niza
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= r) { //ako ima preostanato od vtora niza
            temp[k] = a[j];
            j++;
            k++;
        }

        for (k = 0; k < numel; k++) { //prepisuvanje na sortiranite elementi vo originalnata niza
            a[l + k] = temp[k];
        }
    }

    public static void mergeSort(int a[], int l, int r) {
        if (l == r) { //ako ima samo eden element
            return;
        }

        int mid = (l + r) / 2;
        mergeSort(a, l, mid);          //sortiranje na prva polovina
        mergeSort(a, mid + 1, r);   //sortiranje na vtora polovina
        merge(a, l, mid, r);           //spoj na dvete sortirani nizi
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int a[] = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        mergeSort(a, 0, N - 1);

        for (int i = 0; i < N; i++) {
            System.out.print(a[i]);
        }

    }
}
