package Auditoriski.NiziListi;

public class DLL<E extends Comparable<E>> {
    private DLLNode<E> first, last;

    public DLL() {
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> temp = first;
        while (temp != null) {
            listSize++;
            temp = temp.succ;
        }
        return listSize;
    }

    public int length() {
        int ret;
        if (first != null) {
            DLLNode<E> temp = first;
            ret = 1;
            while (temp.succ != null) {
                temp = temp.succ;
                ret++;
            }
            return ret;
        } else {
            return 0;
        }
    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null) { //dodeka ne go najde ili e kraj
                tmp = tmp.succ;
            }
            //proverka na sto pricinalo da izleze od while-ot
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo nizata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<>(o, null, first); //sledbenik e orig. prv
        if (first == null) { // ako nema jazol
            last = ins; //prethodno null sega ke e noviot jazol
        } else {
            first.pred = ins; // ako ima, odi kon nego
        }
        first = ins; //sega stanuva prv
    }


    public void insertLast(E o) {
        if (first == null) {
            insertFirst(o); //ako nema, isto e
        } else {
            DLLNode<E> ins = new DLLNode<>(o, last, null); //prethodnik bil orig. posleden
            last.succ = ins; //sledbenik mu e noviot
            last = ins; // sega noviot e posleden
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o); //ako e vekje posleden
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ); //prethodnik i sledbenik
        after.succ.pred = ins; //levata strelka <-
        after.succ = ins;//desnata strelka ->
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);//ako e vekje prv
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);//prethodnik i sledbenik
        before.pred.succ = ins; //desnata strelka ->
        before.pred = ins;//levata strelka <-
    }

    public void mirror() {
        DLLNode<E> current = this.first;
        while (current != null) {
            DLLNode<E> pred = current.pred;
            DLLNode<E> succ = current.succ;

            current.succ = pred;
            current.pred = succ;
            current = succ;
        }

        current = last;
        last = first;
        first = current;
    }

    public E deleteFirst() {
        if (first != null) {//ako ima nesto
            DLLNode<E> tmp = first;
            first = first.succ; //go nosime na vtoriot
            if (first != null) {//ako ima nesto pred nego
                first.pred = null;
            }
            if (first == null) {
                last = null;
            }
            return tmp.element;
        } else {
            return null;
        }
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null) {
                return deleteFirst();
            } else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else {
            return null;
        }
    }

    public E delete(DLLNode<E> node) {
        if (node == first) { //ako e prv
            deleteFirst();
            return node.element;
        }
        if (node == last) { //ako e posleden
            deleteLast();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element; //ne pokazuva nisto KON nego = Garbage Collection
    }

    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            DLLNode<E> tmp = first;
//            ret += tmp + "<->";
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += tmp + "<->";
//            }
//        } else {
//            ret = "Listata e prazna";
//        }
//        return ret;
//    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret.append(tmp).append("<->");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                if (tmp.succ != null)
                    ret.append(tmp).append("<->");
                else
                    ret.append(tmp);
            }
        } else {
            ret = new StringBuilder("Listata e prazna");
        }
        return ret.toString();
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp + "<->";
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += tmp + "<->";
            }
        } else {
            ret = "Listata e prazna";
        }
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {
        return last;
    }

    public void removeDuplicates() {
        if (first != null) {
            DLLNode<E> tmp = first;
            DLLNode<E> tmp2 = tmp.succ;

            while (tmp.succ != null) {
                while (tmp2 != null) {
                    if (tmp.element.compareTo(tmp2.element) == 0) {
                        if (tmp2.succ != null) {
                            tmp2 = tmp2.succ;
                            this.delete(tmp2.pred);
                        } else {
                            this.delete(tmp2);
                            tmp2 = null;
                        }
                    } else {
                        tmp2 = tmp2.succ;
                    }
                }
                tmp = tmp.succ;
                if (tmp == null) break;
                tmp2 = tmp.succ;
            }

        }
    }
}
