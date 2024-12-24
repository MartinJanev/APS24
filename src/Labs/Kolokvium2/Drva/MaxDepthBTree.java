package Labs.Kolokvium2.Drva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class MaxDepthBTree {

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

            BNode<E> tmp = new BNode<E>(elem, node);

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

        public void inorder() {
            System.out.print("INORDER: ");
            inorderR(root);
            System.out.println();
        }

        public void inorderR(BNode<E> n) {
            if (n != null) {
                inorderR(n.left);
                System.out.print(n.info.toString() + " ");
                inorderR(n.right);
            }
        }

        public void preorder() {
            System.out.print("PREORDER: ");
            preorderR(root);
            System.out.println();
        }

        public void preorderR(BNode<E> n) {
            if (n != null) {
                System.out.print(n.info.toString() + " ");
                preorderR(n.left);
                preorderR(n.right);
            }
        }

        public void postorder() {
            System.out.print("POSTORDER: ");
            postorderR(root);
            System.out.println();
        }

        public void postorderR(BNode<E> n) {
            if (n != null) {
                postorderR(n.left);
                postorderR(n.right);
                System.out.print(n.info.toString() + " ");
            }
        }

//        public void inorderNonRecursive() {
//            ArrayStack<BNode<E>> s = new ArrayStack<BNode<E>>(100);
//            BNode<E> p = root;
//            System.out.print("INORDER (nonrecursive): ");
//
//            while (true) {
//                // pridvizuvanje do kraj vo leva nasoka pri sto site koreni
//                // na potstebla se dodavaat vo magacin za podocnezna obrabotka
//                while (p != null) {
//                    s.push(p);
//                    p = p.left;
//                }
//
//                // ako magacinot e prazen znaci deka stebloto e celosno izminato
//                if (s.isEmpty())
//                    break;
//
//                p = s.peek();
//                // pecatenje (obrabotka) na jazelot na vrvot od magacinot
//                System.out.print(p.info.toString() + " ");
//                // brisenje na obraboteniot jazel od magacinot
//                s.pop();
//                // pridvizuvanje vo desno od obraboteniot jazel i povtoruvanje na
//                // postapkata za desnoto potsteblo na jazelot
//                p = p.right;
//
//            }
//            System.out.println();
//
//        }

        int insideNodesR(BNode<E> node) {
            if (node == null)
                return 0;

            if ((node.left == null) && (node.right == null))
                return 0;

            return insideNodesR(node.left) + insideNodesR(node.right) + 1;
        }

        public int insideNodes() {
            return insideNodesR(root);
        }

        int leavesR(BNode<E> node) {
            if (node != null) {
                if ((node.left == null) && (node.right == null))
                    return 1;
                else
                    return (leavesR(node.left) + leavesR(node.right));
            } else {
                return 0;
            }
        }

        public int leaves() {
            return leavesR(root);
        }

        int depthR(BNode<E> node) {
            if (node == null)
                return 0;
            if ((node.left == null) && (node.right == null))
                return 1;
            return (1 + Math.max(depthR(node.left), depthR(node.right)));
        }

        public int depth() {
            return depthR(root);
        }

        void mirrorR(BNode<E> node) {
            BNode<E> tmp;

            if (node == null)
                return;

            // simetricno preslikuvanje na levoto i desnoto potsteblo
            mirrorR(node.left);
            mirrorR(node.right);

            // smena na ulogite na pokazuvacite na momentalniot jazel
            tmp = node.left;
            node.left = node.right;
            node.right = tmp;

        }

        public void mirror() {
            mirrorR(root);
        }

    }

    static class BNode<E> {

        public E info;
        public BNode<E> left;
        public BNode<E> right;

        public static int LEFT = 1;
        public static int RIGHT = 2;

        public BNode<E> parent;

        public BNode(E info, BNode<E> parent) {
            this.parent = parent;
            this.info = info;
            left = null;
            right = null;
        }

        public BNode(E info) {
            this.parent = null;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] is = br.readLine().split(" ");
        int n = Integer.parseInt(is[0]) + Integer.parseInt(is[1]);

        BTree<String> tree = new BTree<>();
        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split(" ");
            if (token[0].equals("root")) {
                String rootValue = token[1];
                tree.makeRoot(rootValue);
            } else if (token[0].equals("add")) {
                String parentValue = token[1];
                String childValue = token[2];
                String direction = token[3];

                int dir = 0;
                if (direction.equals("LEFT")) {
                    dir = 1;
                } else if (direction.equals("RIGHT")) {
                    dir = 2;
                }

                BNode<String> parentNode = find(tree.root, parentValue);
                BNode<String> childNode = tree.addChild(parentNode, dir, childValue);
            } else if (token[0].equals("ask")) {
                String childVal = token[1];
                BNode<String> child = find(tree.root, childVal);
                int dlabocina = tree.depthR(child);
                System.out.println(dlabocina);
            }
        }
    }

    static BNode<String> find(BNode<String> node, String target) {
        if (node == null) return null;
        if (Objects.equals(node.info, target)) return node;

        BNode<String> levo = find(node.left, target);
        BNode<String> desno = find(node.right, target);

        if (levo != null) {
            return levo;
        } else {
            return desno;
        }
    }
}