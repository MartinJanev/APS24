package Auditoriski.ArrayLists;

import java.util.Scanner;

public class RemoveDuplicates<E> {

    public void RemoveDuplicates(Array<E> niza) {
        for (int i = 0; i < niza.getSize()-1; i++) {
            if (niza.get(i).equals(niza.get(i + 1))) {
                niza.delete(i+1);
                i--;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Array<Integer> niza = new Array<>(N);

        for (int i = 0; i < N; i++) {
            niza.insertLast(sc.nextInt());
        }

        System.out.println(niza.toString());

        RemoveDuplicates<Integer> pom = new RemoveDuplicates<Integer>();
        pom.RemoveDuplicates(niza);

        System.out.println(niza.toString());
    }
}
