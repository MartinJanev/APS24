package Auditoriski.NiziListi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RazdeliLista<E> {

    public static void razdeliLista(SLL<Integer> lista) {
        SLL<Integer> parni = new SLL<Integer>();
        SLL<Integer> neparni = new SLL<Integer>();

        SLLNode<Integer> pom = lista.getFirst();
        while (pom != null) {
            if (pom.element % 2 == 0) {
                parni.insertLast(pom.element);
            } else {
                neparni.insertLast(pom.element);
            }
            pom = pom.succ;
        }
        if (parni.size() == 0 || neparni.size() == 0) {
            System.out.println("Prazna lista");
        } else {
            System.out.println(parni);
            System.out.println(neparni);
        }
    }

    public static void main(String[] args) throws IOException {
        SLL<Integer> lista = new SLL<Integer>();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        int N = Integer.parseInt(s);
        s = input.readLine();
        String[] podniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(podniza[i]));
        }
        razdeliLista(lista);
    }
}
