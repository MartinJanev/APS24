package Kolokviumski.PrvKolokvium;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.util.NoSuchElementException;

interface Queue<E> {
    int size();

    boolean isEmpty();

    void clear();

    E peek();

    void enqueue(E el);

    E dequeue();
}

class ArrayQueue<E> implements Queue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
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
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}


public class TrikSoKarti {
    public static int count(int N) {
        ArrayQueue<Integer> spil = new ArrayQueue<Integer>(51);
        Stack<Integer> inverted = new Stack<Integer>();

        for (int i = 1; i <= 51; i++) {
            spil.enqueue(i);
        }

        int brojMesanja = 0;

        while (spil.peek() != N) {
            for (int i = 0; i < 7; i++) {
                inverted.push(spil.dequeue());
            }
            while (!inverted.isEmpty()) {
                spil.enqueue(inverted.pop());
                spil.enqueue(spil.dequeue());
            }
            brojMesanja++;
        }
        return brojMesanja;

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}
