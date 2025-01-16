package Kolokviumski.VtorKolokvium;

import java.util.Scanner;

public class BSTfromPreorder {

    // BNode class represents a node in the binary tree
    static class BNode<E> {
        public E info;
        public BNode<E> left;
        public BNode<E> right;

        static int LEFT = 1;
        static int RIGHT = 2;

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

    // BTree class represents the binary tree with a root node
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
            BNode<E> tmp = new BNode<E>(elem);

            if (where == BNode.LEFT) {
                if (node.left != null)  // if left child already exists
                    return null;
                node.left = tmp;
            } else {
                if (node.right != null) // if right child already exists
                    return null;
                node.right = tmp;
            }

            return tmp;
        }

        // Preorder traversal for verifying tree structure
        public void preorder(BNode<E> n) {
            if (n != null) {
                System.out.print(n.info.toString() + " "); // root
                preorder(n.left); // left
                preorder(n.right); // right
            }
        }
    }

    // Method to insert elements into the Binary Search Tree
    public BNode<Integer> insert(BNode<Integer> root, int val) {
        if (root == null) {
            return new BNode<>(val);
        }
        if (root.info != null && root.info > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Method to create the BST from a preorder traversal
    public BNode<Integer> bstFromPreorder(int[] preorder) {
        BNode<Integer> root = null;
        for (int n : preorder) {
            root = insert(root, n);  // Insert elements one by one
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline character

        int[] preorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        BSTfromPreorder solution = new BSTfromPreorder();
        BTree<Integer> tree = new BTree<>();
        tree.root = solution.bstFromPreorder(preorder);

        // Print the tree's preorder traversal to verify the structure
        System.out.print("Preorder traversal: ");
        tree.preorder(tree.root);
        System.out.println();  // Newline after the preorder traversal
    }
}
