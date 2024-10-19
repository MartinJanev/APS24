package Auditoriski.ArrayLists;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SwapPairs {

    public static void main(String[] args) throws Exception {
        SLL<Integer> lista = new SLL<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(br.readLine()));
        }

        SLLNode<Integer> jazol = lista.getFirst();
        while (jazol != null && jazol.getSucc() != null) {
              Integer pom = jazol.element;
              jazol.element = jazol.succ.element;
              jazol.succ.element = pom;
              jazol = jazol.succ.succ;
        }
        System.out.println(lista.toString());
    }
}
