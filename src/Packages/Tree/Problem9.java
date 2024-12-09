package Packages.Tree;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Problem9 {

    interface Stack<E> {

        // Elementi na stekot se objekti od proizvolen tip.

        // Metodi za pristap:

        public boolean isEmpty();
        // Vrakja true ako i samo ako stekot e prazen.

        public E peek();
        // Go vrakja elementot na vrvot od stekot.

        // Metodi za transformacija:

        public void clear();
        // Go prazni stekot.

        public void push(E x);
        // Go dodava x na vrvot na stekot.

        public E pop();
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
    }

    static class ArrayStack<E> implements Stack<E> {
        private E[] elems;
        private int depth;

        @SuppressWarnings("unchecked")
        public ArrayStack(int maxDepth) {
            // Konstrukcija na nov, prazen stek.
            elems = (E[]) new Object[maxDepth];
            depth = 0;
        }


        public boolean isEmpty() {
            // Vrakja true ako i samo ako stekot e prazen.
            return (depth == 0);
        }


        public E peek() {
            // Go vrakja elementot na vrvot od stekot.
            if (depth == 0)
                throw new NoSuchElementException();
            return elems[depth - 1];
        }


        public void clear() {
            // Go prazni stekot.
            for (int i = 0; i < depth; i++) elems[i] = null;
            depth = 0;
        }


        public void push(E x) {
            // Go dodava x na vrvot na stekot.
            elems[depth++] = x;
        }


        public E pop() {
            // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
            if (depth == 0)
                throw new NoSuchElementException();
            E topmost = elems[--depth];
            elems[depth] = null;
            return topmost;
        }
    }

    static class BNode<E> {

        public E info;
        public BNode<E> left;
        public BNode<E> right;
        public BNode<E> parent;

        static int LEFT = 1;
        static int RIGHT = 2;

        public BNode(E info) {
            this.info = info;
            left = null;
            right = null;
            this.parent = null;
        }

        public BNode(E info, BNode<E> left, BNode<E> right) {
            this.info = info;
            this.left = left;
            this.right = right;
        }

        public BNode(E info, BNode<E> parent) {
            this.info = info;
            this.parent = parent;
        }
    }

    static class BTree<E> {

        public BNode<E> root;

        public BTree() {
            root = null;
        }

        public BTree(E info) {
            root = new BNode<E>(info);
        }

        public void makeRoot(E elem) {
            root = new BNode<E>(elem);
        }

        public BNode<E> addChild(BNode<E> node, int where, E elem) {
            BNode<E> tmp = new BNode<E>(elem, node);
            if (where == BNode.LEFT) {
                if (node.left != null)  // veke postoi element
                    return null;
                node.left = tmp;
            } else {
                if (node.right != null) // veke postoi element
                    return null;
                node.right = tmp;
            }

            return tmp;
        }

        public void inorder() {
            System.out.print("INORDER: ");
            inorderR(root);
            System.out.println();
        }

        public void inorderR(BNode<E> n) {
            if (n != null) {
                inorderR(n.left);
                System.out.print(n.info.toString() + " ");
                inorderR(n.right);
            }
        }

        public void preorder() {
            System.out.print("PREORDER: ");
            preorderR(root);
            System.out.println();
        }

        public void preorderR(BNode<E> n) {
            if (n != null) {
                System.out.print(n.info.toString() + " ");
                preorderR(n.left);
                preorderR(n.right);
            }
        }

        public void postorder() {
            System.out.print("POSTORDER: ");
            postorderR(root);
            System.out.println();
        }

        public void postorderR(BNode<E> n) {
            if (n != null) {
                postorderR(n.left);
                postorderR(n.right);
                System.out.print(n.info.toString() + " ");
            }
        }

        public void inorderNonRecursive() {
            ArrayStack<BNode<E>> s = new ArrayStack<BNode<E>>(100);
            BNode<E> p = root;
            System.out.print("INORDER (nonrecursive): ");

            while (true) {
                // pridvizuvanje do kraj vo leva nasoka pri sto site koreni
                // na potstebla se dodavaat vo magacin za podocnezna obrabotka
                while (p != null) {
                    s.push(p);
                    p = p.left;
                }

                // ako magacinot e prazen znaci deka stebloto e celosno izminato
                if (s.isEmpty())
                    break;

                p = s.peek();
                // pecatenje (obrabotka) na jazelot na vrvot od magacinot
                System.out.print(p.info.toString() + " ");
                // brisenje na obraboteniot jazel od magacinot
                s.pop();
                // pridvizuvanje vo desno od obraboteniot jazel i povtoruvanje na
                // postapkata za desnoto potsteblo na jazelot
                p = p.right;

            }
            System.out.println();

        }

        int insideNodesR(BNode<E> node) {
            if (node == null)
                return 0;

            if ((node.left == null) && (node.right == null))
                return 0;

            return insideNodesR(node.left) + insideNodesR(node.right) + 1;
        }

        public int insideNodes() {
            return insideNodesR(root);
        }

        int leavesR(BNode<E> node) {
            if (node != null) {
                if ((node.left == null) && (node.right == null))
                    return 1;
                else
                    return (leavesR(node.left) + leavesR(node.right));
            } else {
                return 0;
            }
        }

        public int leaves() {
            return leavesR(root);
        }

        int depthR(BNode<E> node) {
            if (node == null)
                return 0;
            if ((node.left == null) && (node.right == null))
                return 0;
            return (1 + Math.max(depthR(node.left), depthR(node.right)));
        }

        public int depth() {
            return depthR(root);
        }

        void mirrorR(BNode<E> node) {
            BNode<E> tmp;

            if (node == null)
                return;

            // simetricno preslikuvanje na levoto i desnoto potsteblo
            mirrorR(node.left);
            mirrorR(node.right);

            // smena na ulogite na pokazuvacite na momentalniot jazel
            tmp = node.left;
            node.left = node.right;
            node.right = tmp;

        }

        public void mirror() {
            mirrorR(root);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        BTree<Integer> tree = new BTree<>();

        // Step 1: Enter the root node
        int rootValue = Integer.parseInt(sc.nextLine());
        tree.makeRoot(rootValue);

        // Step 2: Enter the remaining n-1 nodes
        System.out.println("Enter the parent-child relationships:");
        for (int i = 1; i < n; i++) {
            String[] row = sc.nextLine().split(" ");
            int parentValue = Integer.parseInt(row[0]);
            int childValue = Integer.parseInt(row[1]);
            int position = Integer.parseInt(row[2]); // 1 - LEFT 2 - RIGHT

            BNode<Integer> parentNode = findNode(tree.root, parentValue);
            if (parentNode == null) {
                System.out.println("Parent node not found. Skipping this relationship.");
                continue;
            }

            BNode<Integer> childNode = tree.addChild(parentNode, position, childValue);
            if (childNode == null) {
                System.out.println("Child node could not be added. Skipping this relationship.");
            }
        }

        // Step 3: Enter a target node value and find the path to it
        System.out.print("Enter the value of the node to find the path to: ");
        int targetValue = sc.nextInt();

        BNode<Integer> targetNode = findNode(tree.root, targetValue);
        if (targetNode != null) {
            System.out.println("Path to root: " + pathToRoot(targetNode));
        } else {
            System.out.println("Node with value " + targetValue + " not found.");
        }
    }

    // Helper method to find a node with a specific value
    static BNode<Integer> findNode(BNode<Integer> node, int target) {
        if (node == null) {
            return null;
        }

        if (node.info == target) {
            return node;
        }

        BNode<Integer> leftSearch = findNode(node.left, target);
        if (leftSearch != null) {
            return leftSearch;
        }

        return findNode(node.right, target);
    }

    // Method to get the path from a node to the root
    static String pathToRoot(BNode<Integer> node) {
        StringBuilder path = new StringBuilder();
        while (node != null) {
            path.insert(0, "<" + node.info + "> ");
            node = node.parent;
        }
        return path.toString();
    }
}
