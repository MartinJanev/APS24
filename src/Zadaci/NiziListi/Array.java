package Zadaci.NiziListi;

import java.util.Arrays;

public class Array<E> {
    private E data[];
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public void set(int index, E o) {
        if (index >= 0 && index < size) {
            data[index] = o;
        } else {
            System.out.println("Ne moze da se vmetne element na dadaenata niza");
        }
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            return data[index];
        } else {
            System.out.println("Ne e validna pozicijata");
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public int find(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void insert(int index, E o) {
        if (index >= 0 && index < size) {
            if (size + 1 > data.length) {
                this.resize();
            }
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = o;
            size++;
        } else {
            System.out.println("Ne moze da se vmetne element na taa pozicija");
        }
    }

    public void insertLast(E o) {
        if (size + 1 > data.length) {
            this.resize();
        }
        data[size++] = o;
    }

    public void delete(int index) {
        if (index >= 0 && index < size) {
            E[] newData = (E[]) new Object[size - 1];
            for (int i = 0; i < index; i++) {
                newData[i] = data[i];
            }
            for (int i = index + 1; i < size; i++) {
                newData[i - 1] = data[i];
            }
            data = newData;
            size--;
        }
    }

    public void resize() {
        E[] newData = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    public void resize(int newSize) {
        E[] newData = (E[]) new Object[newSize];
        int copySize = size;
        if (newSize < size) {
            copySize = newSize;
        }
        for (int i = 0; i < newSize; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = newSize;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
