package Zadaci.NiziListi;

public class DLLNode<E extends Comparable<E>> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E element, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = element;
        this.pred = pred;
        this.succ = succ;
    }


    @Override
    public String toString() {
        return element.toString();
    }
}
