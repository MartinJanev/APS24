package Labs.Kolokvium2.Drva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BinaryTreeSum {

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

    }

    static class BTree<E extends Comparable<E>> {

        public BNode<E> root;

        public BTree() {
            root = null;
        }

        public BTree(E info) {
            root = new BNode<E>(info);
        }

        public void makeRoot(E elem) {
            root = new BNode(elem);
        }

        public void makeRootNode(BNode<E> node) {
            root = node;
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

        public BNode<E> najdiTeme(E N) {
            if (root == null) return null;

            Stack<BNode<E>> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                BNode<E> current = stack.pop();
                if (current.info.equals(N)) return current;

                if (current.right != null) stack.push(current.right);
                if (current.left != null) stack.push(current.left);
            }
            return null;
        }

        public int najdiSuma(BNode<Integer> q, int k) {
            BNode<Integer> start = (k == 1) ? q.left : q.right;
            if (start == null) return 0;

            Stack<BNode<Integer>> stack = new Stack<>();
            stack.push(start);

            int sum = 0;
            while (!stack.isEmpty()) {
                BNode<Integer> current = stack.pop();

                if (current.info > q.info && k == 0) sum += current.info;
                if (current.info < q.info && k == 1) sum += current.info;

                if (current.right != null) stack.push(current.right);
                if (current.left != null) stack.push(current.left);
            }
            return sum;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        BNode<Integer>[] nodes = new BNode[N];
        BTree<Integer> tree = new BTree<>();

        for (int i = 0; i < N; i++) nodes[i] = new BNode<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            String action = st.nextToken();

            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                tree.makeRootNode(nodes[index]);
            }
        }


        int baranaVrednost = Integer.parseInt(br.readLine());

        BNode neso = tree.najdiTeme(baranaVrednost);
        if (neso.left != null) System.out.print(tree.najdiSuma(neso, 1) + " ");
        else System.out.print("0 ");
        if (neso.right != null) System.out.print(tree.najdiSuma(neso, 0));
        else System.out.print("0");

    }
}
