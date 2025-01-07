package Kolokviumski.PrvKolokvium;

import java.util.Scanner;

//Во еднострано поврзана листа избришете ги сите јазли чии вредности се јавуваат парен број пари.
// Смеете да користите само ЕДНА листа!
public class DeleteEvenNodes {

    public static void deleteEven(SLL<Integer> list1) {
        SLLNode<Integer> current = list1.getFirst();
        int max = Integer.MIN_VALUE;
        while (current != null) {
            if (current.element>max){
                max = current.element;
            }
            current = current.succ;
        }
        int[] dp = new int[max+1];
        current = list1.getFirst();
        while (current != null) {
            dp[current.element]++;
            current = current.succ;
        }

        current = list1.getFirst();
        while (current != null) {
            if (dp[current.element] % 2 == 0) {
                list1.delete(current);
            }
            current = current.succ;
        }
        System.out.println(list1.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.nextInt());
        }
        System.out.println(list1.toString());


        deleteEven(list1);
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

    static class SLL<E> {
        private SLLNode<E> first;

        public SLL() {
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
                ret += tmp;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret += "->" + tmp;
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
}
