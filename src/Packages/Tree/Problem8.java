package Packages.Tree;

import java.util.*;

public class Problem8 {

    static class SLLTree<E> implements Tree<E> {

        // SLLNode is the implementation of the Node interface
        class SLLNode<P> implements Node<P> {

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

        public Tree.Node<E> parent(Tree.Node<E> node) {
            return ((SLLNode<E>) node).parent;
        }

        public int childCount(Tree.Node<E> node) {
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

        public void remove(Tree.Node<E> node) {
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

        class SLLTreeIterator<T> implements Iterator<T> {

            SLLNode<T> start, current;

            public SLLTreeIterator(SLLNode<T> node) {
                start = node;
                current = node;
            }

            public boolean hasNext() {
                return (current != null);
            }

            public T next() throws NoSuchElementException {
                if (current != null) {
                    SLLNode<T> tmp = current;
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

        public Iterator<E> children(Tree.Node<E> node) {
            return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
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

        SLLNode<E> findRecursive(SLLNode<E> node, E searchingFor) {
            if (node == null)
                return null;

            if (node.getElement().equals(searchingFor)) {
                return node;
            }

            SLLNode<E> curr = node.firstChild;
            while (curr != null) {
                SLLNode<E> najdiJazol = findRecursive(curr, searchingFor);
                if (najdiJazol != null) {
                    return najdiJazol;
                }
                curr = curr.sibling;
            }
            return null;
        }
    }

    interface Tree<E> {
        // //////////Accessors ////////////

        public Node<E> root();

        public Node<E> parent(Node<E> node);

        public int childCount(Node<E> node);

        // //////////Transformers ////////////
        public void makeRoot(E elem);

        public Node<E> addChild(Node<E> node, E elem);

        public void remove(Node<E> node);

        // //////////Iterator ////////////
        public Iterator<E> children(Node<E> node);

        // //////Inner interface for tree nodes ////////
        public interface Node<E> {

            public E getElement();

            public void setElement(E elem);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLLTree<String> tree = new SLLTree<String>();
        int n = sc.nextInt();

        String valRoot = sc.next();
        tree.makeRoot(valRoot);

        for (int i = 0; i < n - 1; i++) {
            String valParent = sc.next();
            String valChild = sc.next();

            //najdi go roditelot, od vneseniot red
            SLLTree<String>.SLLNode<String> nodeParent = tree.findRecursive(tree.root, valParent);

            // dodadi go deteto na najdeniot roditel - ako postoi
            if (nodeParent != null) {
                tree.addChild(nodeParent, valChild);
            } else {
                System.out.println("Parent not found: " + valParent);
            }
        }

        tree.printTree();
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        SLLTree<String> tree = new SLLTree<String>();
//        Map<String, Tree.Node<String>> nodes = new HashMap<String, Tree.Node<String>>();
//        int n = sc.nextInt();
//
//
//
//        String valRoot = sc.next();
//        tree.makeRoot(valRoot);
//        Tree.Node<String> nodeRoot = tree.root;
//        nodes.put(valRoot, nodeRoot);
//
//        for (int i = 0; i < n-1; i++) {
//            String valParent = sc.next();
//            String valChild = sc.next();
//
//            Tree.Node<String> nodeParent = nodes.get(valParent);
//            Tree.Node<String> nodeChild = tree.addChild(nodeParent, valChild);
//            nodes.put(valChild, nodeChild);
//        }
//        tree.printTree();
//    }
}
