package Labs.Kolokvium1.ArrayLists;

import java.util.Scanner;

public class InsertTarget {


    class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }
    }

    class SLL<E> {
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

        public void setFirst(SLLNode<E> first) {
            this.first = first;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<String> lista = new InsertTarget().new SLL<String>();
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            lista.insertLast(word);
        }

        System.out.println(lista.toString());
        int target = sc.nextInt();

        SLLNode<String> curr = lista.getFirst();

        while (curr != null) {
            if (curr.element.length() == target) {
                lista.insertAfter("Target", curr);
                curr=curr.succ;
            }
            curr = curr.succ;
        }

        System.out.println(lista.toString());
    }
}