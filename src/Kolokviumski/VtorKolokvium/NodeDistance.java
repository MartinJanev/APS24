package Kolokviumski.VtorKolokvium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class NodeDistance {
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

        public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

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

    }


    public static BNode<String> closestAncestor(String from, String to, BNode<String> node) {
        if (node == null)
            return null;

        if (node.info.equals(from) || node.info.equals(to))
            return node;

        BNode<String> tmp1 = closestAncestor(from, to, node.left);
        BNode<String> tmp2 = closestAncestor(from, to, node.right);

        if (tmp1 == null && tmp2 == null)
            return null;

        if (tmp1 == null)
            return tmp2;
        if (tmp2 == null)
            return tmp1;

        return node;
    }

    public static int minDistance(String from, String to, BTree<String> tree) {
        BNode<String> tmp = closestAncestor(from, to, tree.root);

        int d1 = getLevel(from, tmp, 0);
        int d2 = getLevel(to, tmp, 0);

        if (d1 != -1 && d2 != -1)
            return 2 * (d1 + d2);
        else
            return -1;
    }

    public static int getLevel(String val, BNode<String> node, int level) {
        if (node == null)
            return -1;
        if (node.info.equals(val))
            return level;

        return Math.max(getLevel(val, node.left, level + 1), getLevel(val, node.right, level + 1));
    }

    public static void main(String[] args) throws Exception {
        int i;
        int index;
        String direction;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<String> nodes[] = new BNode[N];
        BTree<String> tree = new BTree<String>();

        for (i = 0; i < N; i++) {
            nodes[i] = new BNode<String>();
        }

        for (i = 0; i < N; i++) {
            line = br.readLine();

            st = new StringTokenizer(line);

            index = Integer.parseInt(st.nextToken());

            nodes[index].info = st.nextToken();

            direction = st.nextToken();

            if (direction.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (direction.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }


        int cases = Integer.parseInt(br.readLine());
        for (int l = 0; l < cases; l++) {
            String split[] = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];

            int minDistance = minDistance(from, to, tree);

            if (minDistance != -1) {
                System.out.println(minDistance);
            } else {
                System.out.println("ERROR");
            }

        }
        br.close();


    }

}