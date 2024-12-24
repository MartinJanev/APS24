package Kolokviumski.TieStoSePadnaa;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

//Да се најде функцијата која повикува најголем број функции од дадени повици на функции. Повиците и враќањата од функции се дадени на влез. На излез да се испечати името на функцијата од која се повикани најголем број други функции. Се бројат само директни повици на функции. Рекурзивни повици нема да бидат излистани. Повиците од нулто ниво се прават од main функцијата.
//
//На влез прво е даден бројот на редови во влезот N, а потоа се излистани повиците и враќањата од процедурите.
//
//Пример влез:
//
//12
//Call a
//Call b
//Call c
//Return
//Call d
//Return
//Call e
//Return
//Return
//Call f
//Return
//Return
//
//Пример излез:
//
//b 3
//
//
//Објаснување:
//Од функцијата b се повикани функциите c, d и е

//

public class StackZadaca {

    static class Call {
        String name;
        int numCalls;

        public Call(String name) {
            this.name = name;
            this.numCalls = 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumCalls() {
            return numCalls;
        }

        public void setNumCalls(int numCalls) {
            this.numCalls = numCalls;
        }

        public int incrementCalls() {
            return this.numCalls++;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayStack<Call> stek = new ArrayStack<>(n);
        int max = 0;
        String maxChar = "";
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            String ch = "";
            String c = "";
            if (!Objects.equals(input, "Return")) {
                ch = sc.next();
                c = ch.substring(0, 1);
            }
            Call called = new Call(c);
            if (Objects.equals(input, "Call")) {
                if (!stek.isEmpty()) {
                    Call a = stek.peek();
                    a.incrementCalls();
                    stek.push(called);
                } else {
                    stek.push(called);
                }
            } else if (Objects.equals(input, "Return")) {
                Call a = stek.pop();
                if (a.numCalls > max) {
                    maxChar = a.name;
                    max = a.numCalls;
                }
            }
        }
        if (max == 0) {
            System.out.println("main "+n/2);
        }
        else {
            System.out.println(maxChar + " " + max);
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

}