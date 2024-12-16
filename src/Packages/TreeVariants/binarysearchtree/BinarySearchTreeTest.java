package Packages.TreeVariants.binarysearchtree;

import java.util.Random;

public class BinarySearchTreeTest {
    // Test program
    public static void main(String[] args) {
        int i;

        Random r = new Random(System.currentTimeMillis());
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        System.out.print("Inserting:");
        for (i = 0; i < 10; i++) {
            int x = r.nextInt(100);
            System.out.print(" " + x);
            bst.insert(x);
        }
        System.out.println();

        bst.printTree();

    }
}
