package Kolokviumski;
//Дадена е низа од големи букви, во која буквата S се појавува парен број пати. После секоја буква S буквата Т се
// појавува еднаш или повеќе пати.Користејќи стек да се одреди дали после секоја буква S (до следната буква S), буквата
// Т се појавува ист број на пати.
//
// На првиот ред од влезот се чита низа од карактери (стринг), на излез се печати 1 доколку буквата Т се појавува ист
// број на пати после секоја S, и нула доколку овој услов не е исполнет.

//ASGTBST
//1

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bukvi {
    static int proveri_t_posle_s(char[] St) {
        ArrayStack<Character> stek = new ArrayStack<Character>(20);
        for (char c : St) {
            if (c == 'S' || c == 'T') {
                if (c == 'S') {
                    if (stek.isEmpty()) {
                        stek.push(c);
                    } else {
                        return 0;
                    }
                } else if (c == 'T') {
                    if (stek.isEmpty()) {
                        return 0;
                    }else {
                        stek.pop();
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        char[] niza = new char[100];


        Scanner f = new Scanner(System.in);
        String st = f.next();
        niza = st.toCharArray();

        int rez = proveri_t_posle_s(niza);
        System.out.println(rez);
    }

    static class ArrayStack<E> implements Stack<E> {
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
}
