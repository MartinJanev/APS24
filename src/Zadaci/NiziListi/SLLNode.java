package Zadaci.NiziListi;

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
