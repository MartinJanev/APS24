package Auditoriski.ArrayLists;

import java.util.Scanner;

public class ChangeArray<E> {

    public static void compareAndChangeArrays(Array<String> arr1, Array<String> arr2) {
        int i = 0, size = arr1.getSize();
        while (i < size) {
            if (arr1.get(i).equals(arr2.get(i))) {
                arr1.delete(i);
                arr2.delete(i);
                size--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Array<String> arr1 = new Array<String>(N);
        Array<String> arr2 = new Array<String>(N);

        for (int i = 0; i < N; i++) {
            arr1.insertLast(sc.nextLine());
        }

        for (int i = 0; i < N; i++) {
            arr2.insertLast(sc.nextLine());
        }

        System.out.println(arr1.toString());
        System.out.println(arr2.toString());

        compareAndChangeArrays(arr1, arr2);

        System.out.println(arr1.toString());
        System.out.println(arr2.toString());
    }
}
