package Labs.Kolokvium1.StackQueue;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Requests {

    public static class Student {
        String name;
        int nBr, nfBr, iBr;

        public Student(String name, int nBr, int nfBr, int iBr) {
            this.name = name;
            this.nBr = nBr;
            this.nfBr = nfBr;
            this.iBr = iBr;
        }


        @Override
        public String toString() {
            return name;
        }

        public boolean isEmpty() {
            return nBr == 0 && nfBr == 0 && iBr == 0;
        }

        public int decrementS() {
            return --nBr;
        }

        public int decrementF() {
            return --nfBr;
        }

        public int decrementH() {
            return --iBr;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());


        LinkedQueue<Student> queueForScience = new LinkedQueue<Student>();
        LinkedQueue<Student> queueForSciFi = new LinkedQueue<Student>();
        LinkedQueue<Student> queueForHistory = new LinkedQueue<Student>();


        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int naukaBr = Integer.parseInt(sc.nextLine());
            int fantastikaBr = Integer.parseInt(sc.nextLine());
            int istorijaBr = Integer.parseInt(sc.nextLine());

            Student kolega = new Student(s, naukaBr, fantastikaBr, istorijaBr);

            if (naukaBr > 0) {
                queueForScience.enqueue(kolega);
            } else if (fantastikaBr > 0) {
                queueForSciFi.enqueue(kolega);
            } else if (istorijaBr > 0) {
                queueForHistory.enqueue(kolega);
            }
        }

        while (!queueForScience.isEmpty() || !queueForSciFi.isEmpty() || !queueForHistory.isEmpty()) {
            for (int i = 0; i < 2 && !queueForScience.isEmpty(); i++) {
                Student koledzi = queueForScience.peek();
                koledzi.decrementS();
                if (koledzi.nBr == 0) {
                    if (koledzi.isEmpty()) {
                        System.out.println(koledzi.name);
                    } else if (koledzi.nfBr > 0) {
                        queueForSciFi.enqueue(koledzi);
                    } else {
                        queueForHistory.enqueue(koledzi);
                    }
                    queueForScience.dequeue();
                }
            }

            if (!queueForSciFi.isEmpty()) {
                Student koledzi = queueForSciFi.peek();
                koledzi.decrementF();
                if (koledzi.nfBr == 0) {
                    if (koledzi.isEmpty()) {
                        System.out.println(koledzi.name);
                    } else if (koledzi.iBr > 0) {
                        queueForHistory.enqueue(koledzi);
                    }
                    queueForSciFi.dequeue();
                }
            }

            for (int i = 0; i < 2 && !queueForHistory.isEmpty(); i++) {
                Student koledzi = queueForHistory.peek();
                koledzi.decrementH();
                if (koledzi.iBr == 0) {
                    System.out.println(koledzi.name);
                    queueForHistory.dequeue();
                }
            }
        }
    }


    static class LinkedQueue<E> implements Queue<E> {

        // Redicata e pretstavena na sledniot nacin:
        // length go sodrzi brojot na elementi.
        // Elementite se zachuvuvaat vo jazli dod SLL
        // front i rear se linkovi do prviot i posledniot jazel soodvetno.
        SLLNode<E> front, rear;
        int length;

        // Konstruktor ...

        public LinkedQueue() {
            clear();
        }

        public boolean isEmpty() {
            // Vrakja true ako i samo ako redicata e prazena.
            return (length == 0);
        }

        public int size() {
            // Ja vrakja dolzinata na redicata.
            return length;
        }

        public E peek() {
            // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
            if (front == null)
                throw new NoSuchElementException();
            return front.element;
        }

        public void clear() {
            // Ja prazni redicata.
            front = rear = null;
            length = 0;
        }

        public void enqueue(E x) {
            // Go dodava x na kraj od redicata.
            SLLNode<E> latest = new SLLNode<E>(x, null);
            if (rear != null) {
                rear.succ = latest;
                rear = latest;
            } else
                front = rear = latest;
            length++;
        }

        public E dequeue() {
            // Go otstranuva i vrakja pochetniot element na redicata.
            if (front != null) {
                E frontmost = front.element;
                front = front.succ;
                if (front == null) rear = null;
                length--;
                return frontmost;
            } else
                throw new NoSuchElementException();
        }

    }

    interface Queue<E> {
        // Elementi na redicata se objekti od proizvolen tip.
        // Metodi za pristap:
        public boolean isEmpty();
        // Vrakja true ako i samo ako redicata e prazena.

        public int size();
        // Ja vrakja dolzinata na redicata.

        public E peek();
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

        // Metodi za transformacija:

        public void clear();
        // Ja prazni redicata.

        public void enqueue(E x);
        // Go dodava x na kraj od redicata.

        public E dequeue();
        // Go otstranuva i vrakja pochetniot element na redicata.
    }

    static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}