package Labs.Kolokvium1.DLL;

import java.util.Scanner;

public class ChangeMForKLeft {
    public static void printer(DLL<Integer> list){
        DLLNode<Integer> tmp = list.getFirst();

        while(tmp!=null) {
            if(tmp.succ==null){
                System.out.print(tmp.element);
            }else{
                System.out.print(tmp.element + "<->");
            }
            tmp = tmp.succ;
        }
        System.out.println();
    }

    public static void changeMforKLeft(DLL<Integer> list, int m, int k) {
        DLLNode<Integer> tmp = list.getFirst();
        DLLNode<Integer> mTrue = null;

        while(tmp!=null){
            if(tmp.element == m){
                mTrue = tmp;
                break;
            }
            tmp = tmp.succ;
        }

        tmp = mTrue;
        boolean flag = false;
        while(k!=0){
            if(tmp.pred == null){
                tmp = list.getLast();
                k--;
                flag = true;
                continue;
            }

            tmp = tmp.pred;
            k--;
        }

        if(tmp == list.getFirst()){
            list.delete(mTrue);
            list.insertBefore(m, tmp);
        }else if(tmp == list.getLast()){
            list.delete(mTrue);
            list.insertLast(m);
        } else if(flag){
            list.delete(mTrue);
            list.insertAfter(m, tmp);
        }else{
            list.delete(mTrue);
            list.insertBefore(m, tmp);
        }


        printer(list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DLL<Integer> list = new ChangeMForKLeft().new DLL<>();

        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int m = sc.nextInt();
        int k = sc.nextInt();

        printer(list);

        DLLNode<Integer> tmp = list.find(m);

        if(tmp==null){
            printer(list);
        }else{
            changeMforKLeft(list, m, k);
        }


    }


    class DLLNode<E> {
        protected E element;
        protected DLLNode<E> pred, succ;

        public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
            this.element = elem;
            this.pred = pred;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    class DLL<E> {
        private DLLNode<E> first, last;

        public DLL() {
            // Construct an empty SLL
            this.first = null;
            this.last = null;
        }

        public void insertFirst(E o) {
            DLLNode<E> ins = new DLLNode<E>(o, null, first);
            if (first == null)
                last = ins;
            else
                first.pred = ins;
            first = ins;
        }

        public void insertLast(E o) {
            if (first == null)
                insertFirst(o);
            else {
                DLLNode<E> ins = new DLLNode<E>(o, last, null);
                last.succ = ins;
                last = ins;
            }
        }

        public void insertAfter(E o, DLLNode<E> after) {
            if (after == last) {
                insertLast(o);
                return;
            }
            DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
            after.succ.pred = ins;
            after.succ = ins;
        }

        public void insertBefore(E o, DLLNode<E> before) {
            if (before == first) {
                insertFirst(o);
                return;
            }
            DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
            before.pred.succ = ins;
            before.pred = ins;
        }

        public E deleteFirst() {
            if (first != null) {
                DLLNode<E> tmp = first;
                first = first.succ;
                if (first != null) first.pred = null;
                if (first == null)
                    last = null;
                return tmp.element;
            } else
                return null;
        }

        public E deleteLast() {
            if (first != null) {
                if (first.succ == null)
                    return deleteFirst();
                else {
                    DLLNode<E> tmp = last;
                    last = last.pred;
                    last.succ = null;
                    return tmp.element;
                }
            } else
                return null;
        }

        public E delete(DLLNode<E> node) {
            if (node == first) {
                return deleteFirst();
            }
            if (node == last) {
                return deleteLast();
            }
            node.pred.succ = node.succ;
            node.succ.pred = node.pred;
            return node.element;

        }

        public DLLNode<E> find(E o) {
            if (first != null) {
                DLLNode<E> tmp = first;
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

        public void deleteList() {
            first = null;
            last = null;
        }

        public int getSize() {
            int listSize = 0;
            DLLNode<E> tmp = first;
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
                DLLNode<E> tmp = first;
                ret += tmp.toString();
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret += "<->" + tmp.toString();
                }
            } else
                ret = "Prazna lista!!!";
            return ret;
        }

        public String toStringR() {
            String ret = new String();
            if (last != null) {
                DLLNode<E> tmp = last;
                ret += tmp.toString();
                while (tmp.pred != null) {
                    tmp = tmp.pred;
                    ret += "<->" + tmp.toString();
                }
            } else
                ret = "Prazna lista!!!";
            return ret;
        }

        public DLLNode<E> getFirst() {
            return first;
        }

        public DLLNode<E> getLast() {

            return last;
        }

        public void mirror() {

            DLLNode<E> tmp = null;
            DLLNode<E> current = first;
            last = first;
            while (current != null) {
                tmp = current.pred;
                current.pred = current.succ;
                current.succ = tmp;
                current = current.pred;
            }

            if (tmp != null && tmp.pred != null) {
                first = tmp.pred;
            }
        }
    }

}