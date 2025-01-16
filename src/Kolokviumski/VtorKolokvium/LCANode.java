package Kolokviumski.VtorKolokvium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCANode {

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

        public BNode() {
            this.info = null;
            left = null;
            right = null;
        }

        public BNode(E info, BNode<E> left, BNode<E> right) {
            this.info = info;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "" + info;
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

        public void makeRootNode(BNode<E> node) {
            root = node;
        }

        public BNode<E> addChild(BNode<E> node, int where, E elem) {
            BNode<E> tmp = new BNode<E>(elem);
            if (where == BNode.LEFT) {
                if (node.left != null) // Already has a left child
                    return null;
                node.left = tmp;
            } else {
                if (node.right != null) // Already has a right child
                    return null;
                node.right = tmp;
            }
            return tmp;
        }

        public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {
            if (where == BNode.LEFT) {
                if (node.left != null)  // Already has a left child
                    return null;
                node.left = tmp;
            } else {
                if (node.right != null) // Already has a right child
                    return null;
                node.right = tmp;
            }
            return tmp;
        }
    }

    // Function to find the Lowest Common Ancestor (LCA) of two nodes in the tree
    public static BNode<String> lowestCommonAncestor(String from, String to, BNode<String> node) {
        if (node == null) {
            return null;  // Base case: if the node is null, return null
        }

        // If either 'from' or 'to' is found, return the current node
        if (node.info.equals(from) || node.info.equals(to)) {
            return node;
        }

        // Recurse into both subtrees
        BNode<String> leftLCA = lowestCommonAncestor(from, to, node.left);
        BNode<String> rightLCA = lowestCommonAncestor(from, to, node.right);

        // If both left and right are non-null, this node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        // Otherwise, return the non-null child
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Main method to read input and process the tree
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());  // Number of nodes
        BNode<String> nodes[] = new BNode[N];
        BTree<String> tree = new BTree<String>();

        // Initialize all nodes
        for (int i = 0; i < N; i++) {
            nodes[i] = new BNode<String>();
        }

        // Read node information
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
            String action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }

        // Process queries
        int cases = Integer.parseInt(br.readLine());
        for (int l = 0; l < cases; l++) {
            String split[] = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];

            // Find the LCA of 'from' and 'to'
            BNode<String> lcaNode = lowestCommonAncestor(from, to, tree.root);

            // Output the result
            if (lcaNode != null) {
                System.out.println(lcaNode.info);  // Output the value of the LCA node
            } else {
                System.out.println("ERROR");  // If no common ancestor is found
            }
        }

        br.close();
    }
}
