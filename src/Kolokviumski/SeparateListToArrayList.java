package Kolokviumski;

import java.util.Scanner;

public class SeparateListToArrayList {

    public static void createNewList(SLL<Integer> list) {
        int n = list.size(); // 14
        SLL<SLL<Integer>> newList = new SLL<SLL<Integer>>();
        double count = (double) n / 10; // 1.4
        int cel = (int) Math.floor(count); // 1
        int ostatok = (int) Math.round((count - cel) * 10); // 4

        SLLNode<Integer> tmp = list.getFirst();

        for (int i = 0; i < ostatok; i++) { // 4 pati
            SLL<Integer> tempList = new SLL<Integer>();
            for (int j = 1; j <= cel + 1; j++) { // 2 pati
                tempList.insertLast(tmp.element);
                tmp = tmp.succ;
            }
            newList.insertLast(tempList);
        }
        for (int i = 0; i < 10 - ostatok; i++) { // 6 pati
            SLL<Integer> tempList = new SLL<Integer>();
            for (int j = 1; j <= cel; j++) { // 1 pat
                tempList.insertLast(tmp.element);
                tmp = tmp.succ;
            }
            newList.insertLast(tempList);
        }
        SLLNode<SLL<Integer>> tmpnode = newList.getFirst();
        while (tmpnode != null) {
            tmpnode.element.toString();
            tmpnode = tmpnode.succ;
        }

    }

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<Integer>();
        Scanner input = new Scanner(System.in);
        var n = input.nextInt();
        for (int i = 0; i < n; i++) {
            lista.insertLast(input.nextInt());
        }
        createNewList(lista);

    }

    static class SLL<E> {
        private SLLNode<E> first;

        public SLL() {
            // Construct an empty SLL
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
                SLLNode<E> tmp = first;
                ret += tmp.element;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret += "->" + tmp.element;
                }
            } else
                ret = "Prazna lista!!!";
            return ret;
        }

        public void insertFirst(E o) {
            SLLNode<E> ins = new SLLNode<E>(o, null);
            ins.succ = first;
            //SLLNode<E> ins = new SLLNode<E>(o, first);
            first = ins;
        }

        public void insertAfter(E o, SLLNode<E> node) {
            if (node != null) {
                SLLNode<E> ins = new SLLNode<E>(o, node.succ);
                node.succ = ins;
            } else {
                System.out.println("Dadenot jazol e null");
            }
        }

        public void insertBefore(E o, SLLNode<E> before) {

            if (first != null) {
                SLLNode<E> tmp = first;
                if (first == before) {
                    this.insertFirst(o);
                    return;
                }
                //ako first!=before
                while (tmp.succ != before && tmp.succ != null)
                    tmp = tmp.succ;
                if (tmp.succ == before) {
                    tmp.succ = new SLLNode<E>(o, before);
                    ;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                }
            } else {
                System.out.println("Listata e prazna");
            }
        }

        public void insertLast(E o) {
            if (first != null) {
                SLLNode<E> tmp = first;
                while (tmp.succ != null)
                    tmp = tmp.succ;
                tmp.succ = new SLLNode<E>(o, null);
            } else {
                insertFirst(o);
            }
        }

        public E deleteFirst() {
            if (first != null) {
                SLLNode<E> tmp = first;
                first = first.succ;
                return tmp.element;
            } else {
                System.out.println("Listata e prazna");
                return null;
            }
        }

        public E delete(SLLNode<E> node) {
            if (first != null) {
                SLLNode<E> tmp = first;
                if (first == node) {
                    return this.deleteFirst();
                }
                while (tmp.succ != node && tmp.succ.succ != null)
                    tmp = tmp.succ;
                if (tmp.succ == node) {
                    tmp.succ = tmp.succ.succ;
                    return node.element;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
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

        public SLLNode<E> find(E o) {
            if (first != null) {
                SLLNode<E> tmp = first;
                while (!tmp.element.equals(o) && tmp.succ != null)
                    tmp = tmp.succ;
                if (tmp.element.equals(o)) {
                    return tmp;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                }
            } else {
                System.out.println("Listata e prazna");
            }
            return null;
        }

        public void merge(SLL<E> in) {
            if (first != null) {
                SLLNode<E> tmp = first;
                while (tmp.succ != null)
                    tmp = tmp.succ;
                tmp.succ = in.getFirst();
            } else {
                first = in.getFirst();
            }
        }

        public void mirror() {
            if (first != null) {
                //m=nextsucc, p=tmp,q=next
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
    }

    static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }
    }


}