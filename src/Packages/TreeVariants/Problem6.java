package Packages.TreeVariants;

import Packages.TreeVariants.binarysearchtree.BNode;
import Packages.TreeVariants.binarysearchtree.BinarySearchTree;

import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        int t = sc.nextInt();

        Integer smaller = findSmaller(bst, t);
        Integer greater = findGreater(bst, t);

        System.out.println("Before: " + (smaller != null ? smaller : "No smaller element"));
        System.out.println("After: " + (greater != null ? greater : "No greater element"));
    }

    private static Integer findSmaller(BinarySearchTree<Integer> bst, int t) {
        return findSmallerRecursive(bst.getRoot(), t, null);
    }

    private static Integer findGreater(BinarySearchTree<Integer> bst, int t) {
        return findGreaterRecursive(bst.getRoot(), t, null);
    }

    private static Integer findSmallerRecursive(BNode<Integer> node, int t, Integer lastSmaller) {
        if (node == null) return lastSmaller;

        if (node.info < t) {
            // Update last smaller and go right
            return findSmallerRecursive(node.right, t, node.info);
        } else {
            // Go left without updating last smaller
            return findSmallerRecursive(node.left, t, lastSmaller);
        }
    }

    private static Integer findGreaterRecursive(BNode<Integer> node, int t, Integer lastGreater) {
        if (node == null) return lastGreater;

        if (node.info > t) {
            // Update last greater and go left
            return findGreaterRecursive(node.left, t, node.info);
        } else {
            // Go right without updating last greater
            return findGreaterRecursive(node.right, t, lastGreater);
        }
    }
}
