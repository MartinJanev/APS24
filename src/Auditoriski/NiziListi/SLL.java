package Auditoriski.NiziListi;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLL<E extends Comparable<E>> {
    private SLLNode<E> first;

    public SLL() {
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while (tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }


    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> temp = first;
            ret += temp.element;
            while (temp.succ != null) {
                temp = temp.succ;
                ret += "->" + temp.element;
            }
        } else {
            ret = "Prazna lista!!";
        }
        return ret;
    }

    public void insertFirst(E e) {
        SLLNode<E> ins = new SLLNode<E>(e, null);
        ins.succ = first;
        first = ins;
    }

    public void insertAfter(E e, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(e, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadeniot jazol e null");
        }
    }

    public void insertBefore(E e, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> temp = first;
            if (first == node) {
                this.insertFirst(e);
                return;
            }
            //first !=node
            while (temp.succ != node && temp.succ != null) {
                temp = temp.succ;
                if (temp.succ == node) {
                    temp.succ = new SLLNode<E>(e, node);
                } else {
                    System.out.println("Dadeniot element ne postoi");
                }
            }
        } else {
            System.out.println("Dadenata lista e prazna");
        }

    }

    public void insertLast(E e) {
        if (first != null) {
            SLLNode<E> temp = first;
            while (temp.succ != null) {
                temp = temp.succ;
            }
            temp.succ = new SLLNode<E>(e, null);
        } else {
            insertFirst(e);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> temp = first;
            first = first.succ;
            return temp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> temp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (temp.succ != node && temp.succ.succ != null)
                temp = temp.succ;
            if (temp.succ == node) {
                temp.succ = temp.succ.succ;
                return node.element;
            } else {
                System.out.println("Element ne postoi vo listata");
                return null;
            }

        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public void setFirst(SLLNode<E> first) {
        this.first = first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo nizata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public Iterator<E> iterator() {
        return new LRIterator<E>();
    }

    private class LRIterator<E> implements Iterator<E> {
        private SLLNode<E> place, current;

        private LRIterator() {
            place = (SLLNode<E>) first;
            current = null;
        }

        public boolean hasNext() {
            return (place != null);
        }

        public E next() {
            if (place == null) {
                throw new NoSuchElementException();
            }
            E nextElement = place.element;
            current = place;
            place = place.succ;
            return nextElement;
        }

        public void remove() {

        }
    }

    public void mirror() {
        if (first != null) {
            SLLNode<E> temp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while (temp != null) {
                next = temp.succ;
                temp.succ = newsucc;
                newsucc = temp;
                temp = next;
            }
            first = newsucc;
        }
    }

    public void merge(SLL<E> in) {
        if (first != null) {
            SLLNode<E> temp = first;
            while (temp.succ != null)
                temp = temp.succ;
            temp.succ = in.getFirst();
        } else {
            first = in.getFirst();
        }
    }

    public SLLNode<E> reverseList(SLLNode<E> node) {
        SLLNode<E> prev = null, curr = node, next;
        while (curr != null) {
            next = curr.succ;
            curr.succ = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public void rearrange() {
        //Find Middle
        SLLNode<E> sredina = this.getFirst();
        for (int i = 1; i < this.size() / 2; i++) {
            sredina = sredina.succ;
        }
        System.out.println(sredina.element);

        //Split list into 2 lists
        SLLNode<E> node1 = this.getFirst();
        SLLNode<E> node2 = sredina.succ;
        sredina.succ = null;

        //Flip the second half
        node2 = reverseList(node2);

        //Alternately connect the nodes
        SLLNode<E> node = new SLLNode<>(null, null);


        SLLNode<E> curr = node;

        while (node1 != null || node2 != null) {
            if (node1 != null) {
                curr.succ = node1;
                curr = curr.succ;
                node1 = node1.succ;
            }

            if (node2 != null) {
                curr.succ = node2;
                curr = curr.succ;
                node2 = node2.succ;
            }
        }
        node = node.succ;
    }

    public void mergeSorted(SLL<E> list) {
        SLLNode<E> first = this.getFirst();
        SLLNode<E> second = list.getFirst();

        while (first != null && second != null) {
            if (first.element.compareTo(second.element) < 0) {
                first = first.succ;
            } else {
                this.insertBefore(second.element, first); //vmetni pred pogolemiot
                second = second.succ; //odi natamo vo taa lista
            }
        }

        while (second != null) {
            this.insertLast(second.element);
            second = second.succ;
        }
    }
}
