package Kolokviumski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class XMLChecker {

    public static boolean isValid(String[] rows) {
        int n = rows.length;
        ArrayStack<String> stack = new XMLChecker().new ArrayStack<>(rows.length);
        for (int i = 0; i < n; i++) {
            if (rows[i].startsWith("[/")) { // closing tag
                String openTag = stack.peek(); // get the last open tag
                rows[i] = rows[i].replace("/", ""); // remove the slash
                if (openTag.equals(rows[i])) { // if the closing tag matches the last open tag
                    stack.pop();
                }
            } else if (rows[i].startsWith("[")) {
                stack.push(rows[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] rows = new String[n];
        for (int i = 0; i < n; i++) {
            rows[i] = br.readLine();
        }

        if (isValid(rows)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }


    interface Stack<E> {
        // Elementi na stekot se objekti od proizvolen tip.
        // Metodi za pristap:

        public boolean isEmpty();
        // Vrakja true ako i samo ako stekot e prazen.

        public E peek();
        // Go vrakja elementot na vrvot od stekot.

        // Metodi za transformacija:
        public void clear();
        // Go prazni stekot.

        public void push(E x);
        // Go dodava x na vrvot na stekot.

        public E pop();
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
    }

    class ArrayStack<E> implements Stack<E> {
        private E[] elems; //elems[0...depth-1] se negovite elementi.
        private int depth; //depth e dlabochinata na stekot

        @SuppressWarnings("unchecked")
        public ArrayStack(int maxDepth) {
            // Konstrukcija na nov, prazen stek.
            elems = (E[]) new Object[maxDepth];
            depth = 0;
        }

        public boolean isEmpty() {
            // Vrakja true ako i samo ako stekot e prazen.
            return (depth == 0);
        }

        public E peek() {
            // Go vrakja elementot na vrvot od stekot.
            if (depth == 0)
                throw new NoSuchElementException();
            return elems[depth - 1];
        }

        public void clear() {
            // Go prazni stekot.
            for (int i = 0; i < depth; i++) elems[i] = null;
            depth = 0;
        }

        public void push(E x) {
            // Go dodava x na vrvot na stekot.
            elems[depth++] = x;
        }

        public int size() {
            // Ja vrakja dolzinata na stack-ot.
            return depth;
        }

        public E pop() {
            // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
            if (depth == 0)
                throw new NoSuchElementException();
            E topmost = elems[--depth];
            elems[depth] = null;
            return topmost;
        }
    }
}
