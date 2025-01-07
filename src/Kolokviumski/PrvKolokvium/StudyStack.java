/*
 * Exercise: Exam Session
 *
 * While preparing for his exams during the June session, Stefan keeps his books
 * stacked on a shelf, one on top of the other. When he needs a book for an exam,
 * he searches for it starting from the top of the stack, one by one, until he finds
 * the desired book. After completing the exam, he puts the book back on the stack
 * on top of all other books.
 *
 * Given the initial order of the books on the shelf (from bottom to top) and the
 * sequence of exams that Stefan takes, your task is to determine how many times
 * each book is taken from the stack and placed back on top. Each such action
 * (removing and returning a book to the stack) is counted as a single "movement."
 *
 * Input:
 * - The first line contains two integers, M (the number of books) and N (the number of exams).
 * - The second line contains M strings representing the book titles, given in the
 *   order they are stacked (from bottom to top).
 * - The third line contains N strings representing the sequence of exams, where each
 *   string corresponds to the title of a book that Stefan needs for the exam.
 *
 * Output:
 * - For each book, print its title and the total number of movements (removals and
 *   returns to the stack). The output should be printed in the same order as the books
 *   were given in the input.
 *
 * Notes:
 * - Each book title is unique.
 * - The names of the books in the output should be printed in the same order as they
 *   appeared in the input.
 *
 * Example Input:
 * 7 3
 * APS OS Mrezhi AOK Objektno Strukturno Kalkulus
 * APS Objektno Mrezhi
 *
 * Example Output:
 * APS 3
 * OS 1
 * Mrezhi 2
 * AOK 2
 * Objektno 3
 * Strukturno 3
 * Kalkulus 3
 */

package Kolokviumski.PrvKolokvium;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudyStack {

    private static int findIndex(String[] books, String book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // Number of books
        int N = sc.nextInt();// Number of exams
        sc.nextLine();
        String[] books = new String[M];
        LinkedStack<String> stack = new LinkedStack<>();
        for (int i = 0; i < M; i++) {
            books[i] = sc.next();
            stack.push(books[i]);
        }
        String[] exams = new String[N];
        for (int i = 0; i < N; i++) {
            exams[i] = sc.next();
        }

        int[] movements = new int[M];
        for (String exam : exams) {
            LinkedStack<String> temp = new LinkedStack<>();
            String currenntBook;
            while (!(currenntBook = stack.pop()).equals(exam)) {
                int index = findIndex(books, currenntBook);
                movements[index]++;
                temp.push(currenntBook);
            }
            int examIndex = findIndex(books, exam);
            movements[examIndex]++;

            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            stack.push(exam);
        }

        for (int i = 0; i < M; i++) {
            System.out.println(books[i] + " " + movements[i]);
        }
    }

    static class SLLNode<E> {
        // Instance variables:
        public E element;
        public SLLNode<E> succ;

        // Constructors:
        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }
    }

    static class LinkedStack<E> implements Stack<E> {
        // top e link do prviot jazol ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
        private SLLNode<E> top;
        int size;

        public LinkedStack() {
            // Konstrukcija na nov, prazen stek.
            top = null;
            size = 0;
        }

        public String toString() {
            SLLNode<E> current = top;
            StringBuilder s = new StringBuilder();
            while (current != null) {
                s.append(current.element);
                s.append(" ");
                current = current.succ;
            }
            return s.toString();
        }

        public boolean isEmpty() {
            // Vrakja true ako i samo ako stekot e prazen.
            return (top == null);
        }

        public void clear() {
            // Go prazni stekot.
            top = null;
            size = 0;
        }

        public E peek() {
            // Go vrakja elementot na vrvot od stekot.
            if (top == null)
                throw new NoSuchElementException();
            return top.element;
        }

        public void push(E x) {
            // Go dodava x na vrvot na stekot.
            top = new SLLNode<E>(x, top);
            size++;
        }

        public int size() {
            // Ja vrakja dolzinata na stekot.
            return size;
        }

        public E pop() {
            // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
            if (top == null)
                throw new NoSuchElementException();
            E topElem = top.element;
            size--;
            top = top.succ;
            return topElem;
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
