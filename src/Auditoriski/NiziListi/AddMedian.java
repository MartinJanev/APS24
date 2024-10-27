package Auditoriski.NiziListi;

import java.util.Scanner;

public class AddMedian<E extends Comparable<E>> {
    public void addMedian(Array<Integer> array) {
        for (int i = 0; i < array.getSize() - 1; i += 2) {
            int median = Math.round((array.get(i) + array.get(i + 1)) / 2.0f);
            array.insert(i+1, median);
            System.out.println(array.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Array<Integer> array = new Array<Integer>(N);

        for (int i = 0; i < N; i++) {
            array.insertLast(sc.nextInt());
        }

        AddMedian<Integer> pom = new AddMedian<>();
        pom.addMedian(array);

        System.out.println(array.toString());
        sc.close();

    }
}
