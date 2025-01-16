package Kolokviumski.VtorKolokvium;

import java.util.*;

public class InorderSuccessor {

    static class BNode<E extends Comparable<E>> {
        public E info;
        public BNode<E> left;
        public BNode<E> right;

        public BNode(E info) {
            this.info = info;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree<E extends Comparable<E>> {
        private BNode<E> root;

        public BinarySearchTree() {
            root = null;
        }

        // Вметнување на елемент во бинарно пребарувачко дрво
        public void insert(E x) {
            root = insert(x, root);
        }

        private BNode<E> insert(E x, BNode<E> t) {
            if (t == null) {
                t = new BNode<>(x);
            } else if (x.compareTo(t.info) < 0) {
                t.left = insert(x, t.left);
            } else if (x.compareTo(t.info) > 0) {
                t.right = insert(x, t.right);
            }
            return t;
        }

        public void inorderTraversal() {
            inorderTraversal(root);
        }

        private void inorderTraversal(BNode<E> t) {
            if (t != null) {
                inorderTraversal(t.left);  // Лево поддрво
                System.out.println(t.info);  // Корен
                inorderTraversal(t.right);  // Десно поддрво
            }
        }
    }

    public static void main(String[] args) {
        // Вчитување на влезните податоци
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // број на елементи (не се користи директно во програмата)

        // Содржина на бинарното пребарувачко дрво
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Вметнување на сите елементи во бинарното дрво
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }

        // Печатење на елементите во растечки редослед (инордер прелаз)
        tree.inorderTraversal();

        scanner.close();
    }
}
