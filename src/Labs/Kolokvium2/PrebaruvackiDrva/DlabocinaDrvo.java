package Labs.Kolokvium2.PrebaruvackiDrva;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DlabocinaDrvo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vals = br.readLine().split(" ");
        int N = Integer.parseInt(vals[0]) + Integer.parseInt(vals[1]);
        BinarySearchTree<Integer> drvo = new BinarySearchTree<Integer>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int jazol = Integer.parseInt(input[1]);
            if (input[0].equals("insert")) {
                drvo.insert(jazol);
            } else if (input[0].equals("ask")) {
                System.out.println(findDepth(drvo.root, jazol));
            }
        }
    }

    static int findDepth(BNode<Integer> root, int x) {
        if (root == null)
            return -1;
        int depth = 0;
        if ((root.info == x) || (depth = findDepth(root.left, x)) >= 0 || (depth = findDepth(root.right, x)) >= 0) {
            return depth + 1;
        }
        return depth;
    }

    static class BNode<E extends Comparable<E>> {

        public E info;
        public BNode<E> left;
        public BNode<E> right;

        public BNode(E info) {
            this.info = info;
            left = null;
            right = null;
        }

        public BNode(E info, BNode<E> left, BNode<E> right) {
            this.info = info;
            this.left = left;
            this.right = right;
        }

    }

    static class BinarySearchTree<E extends Comparable<E>> {

        private BNode<E> root;

        public BinarySearchTree() {
            root = null;
        }

        public void insert(E x) {
            root = insert(x, root);
        }

        public void remove(E x) {
            root = remove(x, root);
        }

        public E findMin() {
            return elementAt(findMin(root));
        }

        public E findMax() {
            return elementAt(findMax(root));
        }

        public BNode<E> find(E x) {
            return find(x, root);
        }

        public void makeEmpty() {
            root = null;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public void printTree() {
            if (isEmpty()) {
                System.out.println("Empty tree");
            } else {
                printTree(root);
            }
        }


        private E elementAt(BNode<E> t) {
            if (t == null)
                return null;
            return t.info;
        }

        private BNode<E> insert(E x, BNode<E> t) {
            if (t == null) {
                t = new BNode<E>(x, null, null);
            } else if (x.compareTo(t.info) < 0) {
                t.left = insert(x, t.left);
            } else if (x.compareTo(t.info) > 0) {
                t.right = insert(x, t.right);
            } else ;  // Duplicate; do nothing
            return t;
        }

        @SuppressWarnings({"raw", "unchecked"})
        private BNode<E> remove(Comparable x, BNode<E> t) {
            if (t == null)
                return t;   // Item not found; do nothing

            if (x.compareTo(t.info) < 0) {
                t.left = remove(x, t.left);
            } else if (x.compareTo(t.info) > 0) {
                t.right = remove(x, t.right);
            } else if (t.left != null && t.right != null) { // Two children
                t.info = findMin(t.right).info;
                t.right = remove(t.info, t.right);
            } else {
                if (t.left != null)
                    return t.left;
                else
                    return t.right;
            }
            return t;
        }

        private BNode<E> findMin(BNode<E> t) {
            if (t == null) {
                return null;
            } else if (t.left == null) {
                return t;
            }
            return findMin(t.left);
        }

        private BNode<E> findMax(BNode<E> t) {
            if (t == null) {
                return null;
            } else if (t.right == null) {
                return t;
            }
            return findMax(t.right);
        }

        private BNode<E> find(E x, BNode<E> t) {
            if (t == null)
                return null;

            if (x.compareTo(t.info) < 0) {
                return find(x, t.left);
            } else if (x.compareTo(t.info) > 0) {
                return find(x, t.right);
            } else {
                return t;    // Match
            }
        }

        private void printTree(BNode<E> t) {
            if (t != null) {
                printTree(t.left);
                System.out.println(t.info);
                printTree(t.right);
            }
        }

        public BNode<E> getRoot() {
            return root;
        }

    }
}