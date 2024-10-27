package Auditoriski.NiziListi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SwapPairs {

    public static void main(String[] args) throws Exception {
        SLL<Integer> lista = new SLL<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        s = br.readLine();
        String[] podniza = s.split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(podniza[i]));
        }

        SLLNode<Integer> jazol = lista.getFirst();
        while (jazol != null && jazol.succ != null) {
            Integer pom = jazol.element;
            jazol.element = jazol.succ.element;
            jazol.succ.element = pom;
            jazol = jazol.succ.succ;
        }
        System.out.println(lista.toString());
    }
}
