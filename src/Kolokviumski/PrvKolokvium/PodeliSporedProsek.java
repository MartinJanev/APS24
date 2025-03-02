package Kolokviumski.PrvKolokvium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PodeliSporedProsek {

    class SLLNode<E> {
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

    class SLL<E> {
        private SLLNode<E> first;

        public SLL() {
            // Construct an empty SLL
            this.first = null;
        }

        public void deleteList() {
            first = null;
        }

        public int length() {
            int ret;
            if (first != null) {
                SLLNode<E> tmp = first;
                ret = 1;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret++;
                }
                return ret;
            } else
                return 0;

        }

        @Override
        public String toString() {
            String ret = new String();
            if (first != null) {
                SLLNode<E> tmp = first;
                ret += tmp + "->";
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret += tmp + "->";
                }
            } else
                ret = "Prazna lista!!!";
            return ret;
        }

        public void insertFirst(E o) {
            SLLNode<E> ins = new SLLNode<E>(o, first);
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
                while (tmp.succ != before)
                    tmp = tmp.succ;
                if (tmp.succ == before) {
                    SLLNode<E> ins = new SLLNode<E>(o, before);
                    tmp.succ = ins;
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
                SLLNode<E> ins = new SLLNode<E>(o, null);
                tmp.succ = ins;
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
                while (tmp.element != o && tmp.succ != null)
                    tmp = tmp.succ;
                if (tmp.element == o) {
                    return tmp;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                }
            } else {
                System.out.println("Listata e prazna");
            }
            return first;
        }

    }


    public static void podeli(SLL<Integer> lista) {
        SLL<Integer> pomali = new PodeliSporedProsek().new SLL<Integer>(), pogolemi = new PodeliSporedProsek().new SLL<Integer>();

        SLLNode<Integer> curr = lista.getFirst();
        int suma = 0;
        while (curr != null) {
            suma += curr.element;
            curr = curr.succ;
        }
        double avg = (double) suma / lista.length();
        curr = lista.getFirst();
        while (curr != null) {
            if (curr.element <= avg)
                pomali.insertLast(curr.element);
            else
                pogolemi.insertLast(curr.element);
            curr = curr.succ;
        }


        //Pechatenje na pomali i ednakvi od prosekot
        SLLNode<Integer> pom = pomali.getFirst();
        while (pom != null) {
            System.out.print(pom.element);
            if (pom.succ != null)
                System.out.print(" ");
            pom = pom.succ;
        }
        System.out.println();

        //Pechatenje na pogolemi od prosekot
        pom = pogolemi.getFirst();
        while (pom != null) {
            System.out.print(pom.element);
            if (pom.succ != null)
                System.out.print(" ");
            pom = pom.succ;
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        SLL<Integer> lista = new PodeliSporedProsek().new SLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        podeli(lista);

    }
}