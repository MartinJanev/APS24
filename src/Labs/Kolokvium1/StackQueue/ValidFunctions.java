//Даден е код на модифициран програмски јазик каде функциите се претставени со отворен и затворен таг
// ("imeFunkcija" и "endimeFunkcija"). Ваша задача е да дефинирате дали даден програмски код е валиден.
//
//
//
//Пример валиден код:
//
//func1
//func2
//endfunc2
//func3
//endfunc3
//endfunc1
//
//
//
//Пример невалиден код (испуштен е затворен таг за func3):
//func1
//func2
//endfunc2
//func3
//endfunc1
//
//Влез: Код со модифициран програмски јазик, каде секој таг е напишан во нов ред.
// Се внесуваат тагови се додека не се внесе "x".
//Излез: "Valid" - доколку е валиден кодот, "Invalid" - доколку не е валиден кодот.
package Labs.Kolokvium1.StackQueue;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ValidFunctions {

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

    public static void main(String[] args) {
        ArrayStack<String> stack = new ValidFunctions().new ArrayStack<>(50);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String line = scanner.nextLine();
            if (line.equals("x")) {
                flag = false;
                if (stack.isEmpty()) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }
            }
            if (line.startsWith("end")) {
                if (stack.isEmpty()) {
                    System.out.println("Invalid");
                    break;
                } else {
                    String openTag = stack.pop();
                    if (!openTag.equals(line.substring(3))) {
                        System.out.println("Invalid");
                        break;
                    }
                }
            } else {
                stack.push(line);
            }
        }

    }

}
