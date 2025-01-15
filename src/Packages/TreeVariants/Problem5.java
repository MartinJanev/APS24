package Packages.TreeVariants;

import Packages.TreeVariants.binarysearchtree.BNode;
import Packages.TreeVariants.binarysearchtree.BinarySearchTree;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        int t = sc.nextInt();
        System.out.println("Before " + smaller(bst, t));
        System.out.println("Before " + greater(bst, t));
    }

    private static int smaller(BinarySearchTree<Integer> bst, int t) {
        return smallerRecursive(bst.getRoot(), t);
    }

    private static int greater(BinarySearchTree<Integer> bst, int t) {
        return greaterRecursive(bst.getRoot(), t);
    }

    private static int smallerRecursive(BNode<Integer> node, int t) {
        if (node.info < t) return smallerRecursive(node.right, t);
        if (node.info == t) return subtreeMin(node.right);
        if (subtreeMax(node.left) == t) return node.info;
        return smallerRecursive(node.left, t);
    }

    private static int greaterRecursive(BNode<Integer> node, int t) {
        if (node.info > t) return greaterRecursive(node.left, t);
        if (node.info == t) return subtreeMax(node.left);
        if (subtreeMin(node.right) == t) return node.info;
        return greaterRecursive(node.right, t);
    }

    private static int subtreeMin(BNode<Integer> node) {
        while (node.left != null) node = node.left;
        return node.info;
    }

    private static int subtreeMax(BNode<Integer> node) {
        while (node.right != null) node = node.right;
        return node.info;
    }
}