package Labs.ArrayLists;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringsFront {

    public class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E element, SLLNode<E> succ) {
            this.element = element;
            this.succ = succ;
        }

        public E getElement() {
            return element;
        }

        public SLLNode<E> getSucc() {
            return succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    public class SLL<E> {
        private SLLNode<E> first;

        public SLL() {
            this.first = null;
        }

        public SLLNode<E> getFirst() {
            return first;
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
            String str = new String();
            if (first != null) {
                SLLNode<E> tmp = first;
                str += tmp.element;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    str += "->" + tmp.element;
                }
            } else {
                str = "Prazna lista!!";
            }
            return str;
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
                SLLNode<E> tmp = first;
                if (first == node) {
                    this.insertFirst(e);
                    return;
                }
                while (tmp.succ != node && tmp.succ != null) {
                    tmp = tmp.succ;
                    if (tmp.succ == node) {
                        tmp.succ = new SLLNode<E>(e, node);
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
                SLLNode<E> tmp = first;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                }
                tmp.succ = new SLLNode<E>(e, null);
            } else {
                first = new SLLNode<E>(e, null);
            }
        }

        public E deleteFirst() {
            if (first != null) {
                SLLNode<E> tmp = first;
                first = first.succ;
                return tmp.element;
            } else {
                System.out.println("Prazen jazol");
                return null;
            }
        }

        public E delete(SLLNode<E> node) {
            if (first != null) {
                SLLNode<E> tmp = first;
                if (first == node) {
                    return this.deleteFirst();
                }
                while (tmp.succ != node && tmp.succ != null) {
                    tmp = tmp.succ;
                }
                if (tmp.succ != null) {
                    tmp.succ = tmp.succ.succ;
                    return node.element;
                } else {
                    System.out.println("Dadeniot jazol ne postoi");
                    return null;
                }
            } else {
                System.out.println("Prazna lista");
                return null;
            }
        }


        public void setFirst(SLLNode<E> first) {
            this.first = first;
        }

        public SLLNode<E> find(E e) {
            if (first != null) {
                SLLNode<E> tmp = first;
                while (tmp != null && !tmp.element.equals(e)) {
                    tmp = tmp.succ;
                }
                if (tmp.element.equals(e)) {
                    return tmp;
                } else {
                    System.out.println("Ne postoi takov element");
                }
            } else {
                System.out.println("Prazna lista");
            }
            return null;
        }

        public Iterator<E> iterator() {
            return new LRIterator<E>();
        }

        private class LRIterator<E> implements Iterator<E> {
            private SLLNode<E> place, current;

            public LRIterator() {
                place = (SLLNode<E>) first;
                current = null;
            }

            @Override
            public boolean hasNext() {
                return place != null;
            }

            @Override
            public E next() {
                if (place == null) {
                    throw new NoSuchElementException();
                }
                E nextElement = place.element;
                current = place;
                place = place.succ;
                return nextElement;
            }

            public void delete() {

            }
        }

        public void mirror() {
            if (first != null) {
                SLLNode<E> tmp = first;
                SLLNode<E> newsucc = null;
                SLLNode<E> next;
                while (tmp != null) {
                    next = tmp.succ;
                    tmp.succ = newsucc;
                    newsucc = tmp;
                    tmp = next;
                }
                first = newsucc;
            }
        }

        public void merge(SLL<E> in) {
            if (first == null) {
                first = in.getFirst();
            } else {
                SLLNode<E> tmp = first;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                }
                tmp.succ = in.getFirst();
            }
        }

        public SLLNode<E> reverseList(SLLNode<E> node) {
            SLLNode<E> prev = null, current = node, next;
            while (current != null) {
                next = current.succ;
                current.succ = prev;
                prev = current;
                current = next;
            }
            node = prev;
            return node;
        }

    }


    public static void main(String[] args) {
        SLL<String> sll = new StringsFront().new SLL<String>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            sll.insertLast(str);
        }

        int length = sc.nextInt();

        SLLNode<String> tmp = sll.getFirst();
        SLLNode<String> prev = null;

        while (tmp != null) {
            if (tmp.element.length() == length) {
                if (prev == null) {
                    tmp = tmp.succ;
                } else {
                    prev.succ = tmp.succ;
                    tmp.succ = sll.getFirst();
                    sll.setFirst(tmp);
                    tmp = prev.succ;
                }
            } else {
                prev = tmp;
                tmp = tmp.succ;
            }
        }
        System.out.println(sll.toString());
    }
}
