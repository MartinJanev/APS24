package Auditoriski.ArrayLists;

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
            while (tmp.element != o && tmp.succ != null) {
                tmp = tmp.succ;
            }
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
        DLLNode<E> ins = new DLLNode<>(o, null, first);
        if (first == null) {
            last = ins;
        } else {
            first.pred = ins;
        }
        first = ins;
    }


    public void insertLast(E o) {
        if (first == null) {
            insertFirst(o);
        } else {
            DLLNode<E> ins = new DLLNode<>(o, last, null);
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
            if (first != null) {
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
        if (node == first) {
            deleteFirst();
            return node.element;
        }
        if (node == last) {
            deleteLast();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;
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
                        tmp.numberApperances++;
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
