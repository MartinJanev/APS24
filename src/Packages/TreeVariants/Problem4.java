package Packages.TreeVariants;

import Packages.TreeVariants.binarysearchtree.BinarySearchTree;
import Packages.TreeVariants.binarysearchtree.BNode;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        System.out.println(k + "`th largest is " + kthLargest(bst, k));
    }

    private static int kthLargest(BinarySearchTree<Integer> bst, int k) {
        return kthLargestInSubtree(bst.getRoot(), k);
    }

    private static int kthLargestInSubtree(BNode<Integer> node, int k) {
        int rightSubtreeSize = subtreeSize(node.right);
        if (rightSubtreeSize >= k) return kthLargestInSubtree(node.right, k);
        else if (rightSubtreeSize + 1 == k) return node.info;
        return kthLargestInSubtree(node.left, k - rightSubtreeSize - 1);
    }

    private static int subtreeSize(BNode<Integer> node) {
        if (node == null) return 0;
        return 1 + subtreeSize(node.left) + subtreeSize(node.right);
    }
}