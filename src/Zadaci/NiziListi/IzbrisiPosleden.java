package Zadaci.NiziListi;

import java.util.Scanner;

public class IzbrisiPosleden<E> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<Integer>();
        for (int i = 0; i < N; i++) {
            int el = sc.nextInt();
            lista.insertLast(el);
        }
        int todelete = sc.nextInt();

        SLLNode<Integer> node = lista.getFirst();
        SLLNode<Integer> del = null;
        while (node != null) {
            if (node.element == todelete) {
                del = node;
            }
            node = node.succ;
        }
        if (del != null) {
            lista.delete(del);
        }
        System.out.println(lista.toString());
    }
}
