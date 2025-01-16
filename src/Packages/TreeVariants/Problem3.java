package Packages.TreeVariants;

import Packages.TreeVariants.binarysearchtree.BinarySearchTree;
import Packages.TreeVariants.binarysearchtree.BNode;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner("9\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("10\n8 2 11 1 5 10 19 3 6 13");
        int n = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        if (isBalanced(bst)) System.out.println("YES");
        else {
            System.out.println("NO");
            balanceTheTree(bst);
        }
    }

    private static void balanceTheTree(BinarySearchTree<Integer> bst) {
        BinarySearchTree<Integer> balanced = new BinarySearchTree<>();
        balanceTheTree(bst.getRoot(), balanced);
        balanced.printTreeWithIndent();
    }

    private static void balanceTheTree(BNode<Integer> node, BinarySearchTree<Integer> balanced) {
        if (node == null) return;
        balanceTheTree(node.left, balanced);
        balanced.insert(node.info);
        balanceTheTree(node.right, balanced);
    }

    private static boolean isBalanced(BinarySearchTree<Integer> bst) {
        return isBalancedSubtree(bst.getRoot());
    }

    private static boolean isBalancedSubtree(BNode<Integer> node) {
        if (node == null) return true;
        int leftHeight = subtreeHeight(node.left);
        int rightHeight = subtreeHeight(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedSubtree(node.left) && isBalancedSubtree(node.right);
    }

    private static int subtreeHeight(BNode<Integer> node) {
        if (node == null) return 0;
        return 1 + Math.max(subtreeHeight(node.left), subtreeHeight(node.right));
    }

}