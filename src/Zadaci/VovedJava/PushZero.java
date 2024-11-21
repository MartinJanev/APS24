package Zadaci.VovedJava;

import java.util.Scanner;

public class PushZero {
    static void pushZerosToBeginning(int arr[], int n) {
        int lim=0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                int j;
                for (j=i; j>lim;j--){
                    arr[j] = arr[j-1];
                }
                arr[j] = 0;
                lim++;
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        pushZerosToBeginning(array,n);
        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
