package Auditoriski.NiziListi;

import java.util.Scanner;

public class DLLPalindrom {
    public static boolean isPalindromList(DLL<Integer> list) {
        DLLNode<Integer> l = list.getFirst();
        DLLNode<Integer> r = list.getLast();

        while (l != r && l.pred != r) {

            if (!(l.element.equals(r.element))) {
                return false;
            }
            l = l.succ;
            r = r.pred;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        DLL<Integer>lista = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextInt());
        }
        System.out.println(isPalindromList(lista)?"Palindrom":"Not Palindrom");
    }
}
