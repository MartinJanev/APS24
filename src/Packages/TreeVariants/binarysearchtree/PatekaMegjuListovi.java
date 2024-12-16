package Packages.TreeVariants.binarysearchtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PatekaMegjuListovi {


    static class BNode {
        public int info;
        public BNode left;
        public BNode right;

        public BNode(int info) {
            this.info = info;
            left = null;
            right = null;
        }

        public BNode(int info, BNode left, BNode right) {
            this.info = info;
            this.left = left;
            this.right = right;
        }
    }

    // An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
    static class Res {
        int val;
    }

    static class BinarySearchTree {
        BNode root; /** The tree root. */
        /** Construct the tree.*/
        public BinarySearchTree() {
            root = null;
        }

        /** Insert into the tree; duplicates are ignored.
         * @param x the item to insert. */
        public void insert(int x) {
            root = insert(x, root);
        }

        public void makeEmpty() {
            root = null;
        }

        /** Internal method to insert into a subtree.
         * @param x the item to insert.
         * @param t the node that roots the tree.
         * @return the new root.*/
        private BNode insert(int x, BNode t) {
            if (t == null) {
                t = new BNode(x, null, null);
            } else if (x < t.info) {
                t.left = insert(x, t.left);
            } else if (x > t.info) {
                t.right = insert(x, t.right);
            } else ; // Duplicate; do nothing
            return t;
        }

        // A utility function to find the maximum sum between any two leaves.
//This function calculates two values:
// 1) Maximum path sum between two leaves which is stored in res.
// 2) The maximum root to leaf path sum which is returned.
// If one side of root is empty, then it returns INT_MIN
        public int maxPathSumUtil(BNode node, Res res) {
// Base cases
            if (node == null)
                return 0;
            if (node.left == null && node.right == null)
                return node.info;
// Find maximum sum in left and right subtree.
// Also, find maximum root to leaf sums in left and right
// subtrees and store them in ls and rs
            int ls = maxPathSumUtil(node.left, res);
            int rs = maxPathSumUtil(node.right, res);
// If both left and right children exist
            if (node.left != null && node.right != null) {
// Update result if needed
                res.val = Math.max(res.val, ls + rs + node.info);
// Return maxium possible value for root being on one side
                return Math.max(ls, rs) + node.info;
            }
// If any of the two children is empty, return root sum for root being on one side
            return (node.left == null) ? rs + node.info : ls + node.info;
        }

        // The main function which returns sum of the maximum sum path between two leaves.
// This function mainly uses maxPathSumUtil()
        public int maxPathSum(BNode node) {
            Res res = new Res();
            res.val = Integer.MIN_VALUE;
            maxPathSumUtil(root, res);
            return res.val;
        }
    }

    //Driver program to test above functions
    public static void main(String args[]) throws Exception {
        int i, j, k;
        BinarySearchTree tree = new BinarySearchTree();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            tree.insert(num);
        }
        br.close();
        System.out.println(tree.maxPathSum(tree.root));
    }
}