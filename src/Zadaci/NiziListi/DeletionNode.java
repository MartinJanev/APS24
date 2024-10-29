package Zadaci.NiziListi;

import java.util.Scanner;

public class DeletionNode {
    public static void deleteNodes(SLL<Integer> list) {
        SLLNode<Integer> curr = list.getFirst();
        int skipStep = 1;

        while (curr != null) {
            for (int i = 0; i < skipStep && curr != null; i++) {
                curr = curr.succ;
            }

            if (curr != null) {
                list.delete(curr);
                curr = curr.succ;
            }
            skipStep++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < N; i++) {
            list.insertLast(sc.nextInt());
        }
        System.out.println(list.toString());


        deleteNodes(list);

        System.out.println(list.toString());

    }
}
