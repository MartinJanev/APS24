package Kolokviumski.TieStoSePadnaa;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QueueZadaca {

    static class Covek {
        String name;
        int baranja;

        public Covek(String name, int baranja) {
            this.name = name;
            this.baranja = baranja;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBaranja() {
            return baranja;
        }

        public void setBaranja(int baranja) {
            this.baranja = baranja;
        }

        public int decrement() {
            return this.baranja--;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedQueue<Covek> redica = new LinkedQueue<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int baranja = sc.nextInt();
            Covek c = new Covek(name, baranja);
            redica.enqueue(c);
        }


        LinkedQueue<Covek> res = new LinkedQueue<>();


        while (!redica.isEmpty()) {
            Covek a = redica.peek();
            a.decrement();
            if (a.getBaranja() == 0) {
                res.enqueue(redica.dequeue());
            } else {

                redica.enqueue(redica.dequeue());
            }
        }

        while (!res.isEmpty()) {
            System.out.println(res.dequeue().name);
        }

//        while (!redica.isEmpty()) {
//            System.out.println(redica.dequeue().name);
//        }


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