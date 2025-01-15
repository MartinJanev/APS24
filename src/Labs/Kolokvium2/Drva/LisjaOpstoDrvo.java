package Labs.Kolokvium2.Drva;

import java.util.*;

public class LisjaOpstoDrvo {
    interface Tree<E> {
        // //////////Accessors ////////////

        public Node<E> root();

        public Node<E> parent(Node<E> node);

        public int childCount(Node<E> node);

        // //////////Transformers ////////////
        public void makeRoot(E elem);

        public Node<E> addChild(Node<E> node, E elem);

        public void remove(Node<E> node);

        // //////////Iterators ////////////
        public Iterator<E> children(Node<E> node);

        public Iterable<Node<E>> childrenNodes(Node<E> node);

        // //////Inner interface for tree nodes ////////
        public interface Node<E> {

            public E getElement();

            public void setElement(E elem);

        }
    }

    static class SLLTree<E> implements Tree<E> {

        // SLLNode is the implementation of the Node interface
        public static class SLLNode<P> implements Node<P> {

            // Holds the links to the needed nodes
            SLLNode<P> parent, sibling, firstChild;

            // Hold the data
            P element;

            public SLLNode(P o) {
                element = o;
                parent = sibling = firstChild = null;
            }

            public P getElement() {
                return element;
            }

            public void setElement(P o) {
                element = o;
            }

        }

        protected SLLNode<E> root;

        public SLLTree() {
            root = null;
        }

        public Node<E> root() {
            return root;
        }

        public Node<E> parent(Node<E> node) {
            return ((SLLNode<E>) node).parent;
        }

        public int childCount(Node<E> node) {
            SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
            int num = 0;
            while (tmp != null) {
                tmp = tmp.sibling;
                num++;
            }
            return num;
        }

        public void makeRoot(E elem) {
            root = new SLLNode<E>(elem);
        }

        public Node<E> addChild(Node<E> node, E elem) {
            SLLNode<E> tmp = new SLLNode<E>(elem);
            SLLNode<E> curr = (SLLNode<E>) node;
            tmp.sibling = curr.firstChild;
            curr.firstChild = tmp;
            tmp.parent = curr;
            return tmp;
        }

        public void remove(Node<E> node) {
            SLLNode<E> curr = (SLLNode<E>) node;
            if (curr.parent != null) {
                if (curr.parent.firstChild == curr) {
                    // The node is the first child of its parent
                    // Reconnect the parent to the next sibling
                    curr.parent.firstChild = curr.sibling;
                } else {
                    // The node is not the first child of its parent
                    // Start from the first and search the node in the sibling list
                    // and remove it
                    SLLNode<E> tmp = curr.parent.firstChild;
                    while (tmp.sibling != curr) {
                        tmp = tmp.sibling;
                    }
                    tmp.sibling = curr.sibling;
                }
            } else {
                root = null;
            }
        }

        class SLLTreeIterator implements Iterator<E> {

            SLLNode<E> start, current;

            public SLLTreeIterator(SLLNode<E> node) {
                start = node;
                current = node;
            }

            public boolean hasNext() {
                return (current != null);
            }

            public E next() throws NoSuchElementException {
                if (current != null) {
                    SLLNode<E> tmp = current;
                    current = current.sibling;
                    return tmp.getElement();
                } else {
                    throw new NoSuchElementException();
                }
            }

            public void remove() {
                if (current != null) {
                    current = current.sibling;
                }
            }
        }

        public Iterator<E> children(Node<E> node) {
            return new SLLTreeIterator(((SLLNode<E>) node).firstChild);
        }


        void printTreeRecursive(Node<E> node, int level) {
            if (node == null)
                return;
            int i;
            SLLNode<E> tmp;

            for (i = 0; i < level; i++)
                System.out.print("  ");
            System.out.println(node.getElement().toString());
            tmp = ((SLLNode<E>) node).firstChild;
            while (tmp != null) {
                printTreeRecursive(tmp, level + 1);
                tmp = tmp.sibling;
            }
        }

        public void printTree() {
            printTreeRecursive(root, 0);
        }

        public int countMaxChildren() {
            return countMaxChildrenRecursive(root);
        }

        int countMaxChildrenRecursive(SLLNode<E> node) {
            int t = childCount(node);
            SLLNode<E> tmp = node.firstChild;
            while (tmp != null) {
                t = Math.max(t, countMaxChildrenRecursive(tmp));
                tmp = tmp.sibling;
            }
            return t;
        }


        @Override
        public Iterable<Node<E>> childrenNodes(Node<E> node) {
            return new NodeIterable(((SLLNode<E>) node).firstChild);
        }

        public class NodeIterable implements Iterable<Node<E>> {

            Node<E> start;

            public NodeIterable(Node<E> start) {
                this.start = start;
            }

            @Override
            public Iterator<Node<E>> iterator() {
                return new NodeIterator(start);
            }
        }

        public class NodeIterator implements Iterator<Node<E>> {
            Node<E> current;

            public NodeIterator(Node<E> node) {
                current = node;
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node<E> next() {
                Node<E> rez = current;
                current = ((SLLNode<E>) current).sibling;
                return rez;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lines = sc.nextLine().split(" ");
        int n = Integer.parseInt(lines[0]) + Integer.parseInt(lines[1]);
        SLLTree<Integer> tree = new SLLTree<Integer>();
        Map<Integer, Tree.Node<Integer>> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            if (Objects.equals(line[0], "root")) {
                int rootVal = Integer.parseInt(line[1]);
                tree.makeRoot(rootVal);
                Tree.Node<Integer> rootNode = tree.root;
                nodes.put(rootVal, rootNode);
            } else if (Objects.equals(line[0], "add")) {
                int parentVal = Integer.parseInt(line[1]);
                int childVal = Integer.parseInt(line[2]);
                Tree.Node<Integer> parentNode = nodes.get(parentVal);
                Tree.Node<Integer> childNode = tree.addChild(parentNode, childVal);
                nodes.put(childVal, childNode);
            } else {
                int childVal = Integer.parseInt(line[1]);
                Tree.Node<Integer> nodeSubTree = nodes.get(childVal);
                int leafCount = countLeaves(tree, nodeSubTree);
                System.out.println(leafCount);
            }
        }
    }

    public static <E> int countLeaves(SLLTree<E> tree, Tree.Node<E> node) {
        int count = 0;
        if (tree.childCount(node) == 0) {
            return 1;
        }
        for (Tree.Node<E> childNode : tree.childrenNodes(node)) {
            count += countLeaves(tree, childNode);
        }
        return count;
    }
}
