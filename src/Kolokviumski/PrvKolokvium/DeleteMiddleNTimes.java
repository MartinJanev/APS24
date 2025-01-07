package Kolokviumski.PrvKolokvium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1 2 6 7 8
//3
/*
    Даена беше еднострано поврзана листа, се бараше N пати да се избрише средината.
    Ако листата е со парен број елементи од 2та средишни елементи се брише помалиот,
    а ако се исти се брише првиот.
    Влез: првата линија број на елементи на листата,вториот ред елементите на листата и во
    третиот ред број колку пати да се избрише средината.
*/

public class DeleteMiddleNTimes {

    public static void deleteMiddle(SLL<Integer> list) {
        SLLNode<Integer> fast = list.getFirst(), curr = list.getFirst();
        while (fast != null && fast.succ != null && fast.succ.succ != null) {
            fast = fast.succ.succ;
            curr = curr.succ;
        }
        if (list.length() % 2 == 0) {
            //delete the smaller out of the two middle elements
            if (curr.element > curr.succ.element) {
                list.delete(curr.succ);
            } else {
                list.delete(curr);
            }
        } else {
            list.delete(curr);
        }
    }

    public static void deleteMiddle(SLL<Integer> list, int delMid) {
        for (int i = 0; i < delMid; i++) {
            deleteMiddle(list);
        }
        System.out.println(list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new DeleteMiddleNTimes().new SLL<>();

        int brElem = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] parts = line.split(" ");
        int delMid = Integer.parseInt(br.readLine());

        for (int i = 0; i < brElem; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }
        deleteMiddle(list, delMid);
    }

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
