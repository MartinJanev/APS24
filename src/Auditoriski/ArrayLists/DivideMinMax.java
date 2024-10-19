package Auditoriski.ArrayLists;

import java.util.Scanner;

public class DivideMinMax {
    public static int findMin(SLL<Integer> list) {
        int min = Integer.MAX_VALUE;
        SLLNode<Integer> curr = list.getFirst();
        while (curr != null) {
            min = Math.min(min, curr.element);
            curr = curr.succ;
        }
        return min;
    }

    public static int findMax(SLL<Integer> list) {
        int max = Integer.MIN_VALUE;
        SLLNode<Integer> curr = list.getFirst();
        while (curr != null) {
            max = Math.max(max, curr.element);
            curr = curr.succ;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        SLL<Integer> minList = new SLL<>();
        SLL<Integer> maxList = new SLL<>();

        for (int i = 0; i < N; i++) {
            list.insertLast(sc.nextInt());
        }

        int min = findMin(list);
        int max = findMax(list);
        SLLNode<Integer> curr = list.getFirst();
        while (curr != null) {
            if (Math.abs(curr.element - min) <= Math.abs(curr.element - max)) {
                minList.insertLast(curr.element);
            } else {
                maxList.insertLast(curr.element);
            }
            curr = curr.succ;
        }

        System.out.println(minList);
        System.out.println(maxList);
    }

}
