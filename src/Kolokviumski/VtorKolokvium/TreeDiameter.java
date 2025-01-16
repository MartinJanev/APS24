package Kolokviumski.VtorKolokvium;

import java.util.Objects;
import java.util.Scanner;

public class TreeDiameter {

    //Binary Tree with Integer values

    //11 9
    //root 1
    //add  1 2 LEFT
    //add 2 3 LEFT
    //ask 3
    //ask 1
    //add 1 4 RIGHT
    //add 3 5 LEFT
    //add 3 6 RIGHT
    //ask 2
    //add 4 7 LEFT
    //add 7 8 RIGHT
    //add 6 9 RIGHT
    //ask 4
    //ask 1
    //ask 3
    //add 2 10 RIGHT
    //add 4 11 RIGHT
    //ask 2
    //ask 1
    //ask 4

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split("\\s+");
        int N = Integer.parseInt(parts[0].trim()) + Integer.parseInt(parts[1].trim());
        BTree<Integer> tree = new BTree<>();
        for (int i = 0; i < N; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            if (tokens[0].equals("root")) {
                Integer value = Integer.parseInt(tokens[1]);
                tree.makeRoot(value);
            } else if (tokens[0].equals("add")) {
                Integer parentValue = Integer.parseInt(tokens[1]);
                Integer childValue = Integer.parseInt(tokens[2]);
                String dir = tokens[3];

                BNode<Integer> parent = findNode(tree.root, parentValue);
                int direction = dir.equals("LEFT") ? 1 : 2;
                tree.addChild(parent, direction, childValue);
            } else if (tokens[0].equals("ask")) {
                System.out.println(treeDiameter(tree));
            }
        }
    }

    static BNode<Integer> findNode(BNode<Integer> node, int value) {
        if (node == null) return null;
        if (Objects.equals(node.info, value)) return node;
        BNode<Integer> left = findNode(node.left, value);
        BNode<Integer> right = findNode(node.right, value);
        if (left != null) return left;
        return right;
    }

    // Calculate the diameter of the binary tree
    public static int treeDiameter(BTree<Integer> tree) {
        if (tree == null || tree.root == null) return 0;
        return diameter(tree.root);
    }

    private static int diameter(BNode<Integer> node) {
        if (node == null) return 0;

        // Get the height of left and right sub-trees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Get the diameter of left and right sub-trees
        int leftDiameter = diameter(node.left);
        int rightDiameter = diameter(node.right);

        // Return the maximum of the following:
        // 1) Diameter of left sub-tree
        // 2) Diameter of right sub-tree
        // 3) Height of left sub-tree + height of right sub-tree + 1
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    private static int height(BNode<Integer> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    //Binary Tree with String values

    //11 9
    //root bravo
    //add bravo echo LEFT
    //add echo beard LEFT
    //ask beard
    //ask bravo
    //add bravo foxtrot RIGHT
    //add beard hotel LEFT
    //add beard india RIGHT
    //ask echo
    //add foxtrot golf LEFT
    //add golf juliet RIGHT
    //add india sierra RIGHT
    //ask foxtrot
    //ask bravo
    //ask beard
    //add echo mike RIGHT
    //add foxtrot tango RIGHT
    //ask echo
    //ask bravo
    //ask foxtrot

//     public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] parts = sc.nextLine().split("\\s+");
//        int n = Integer.parseInt(parts[0].trim());
//        int Q = Integer.parseInt(parts[1].trim());
//        int N = n+Q;
//        BTree<String> tree = new BTree<>();
//        for (int i = 0; i < N; i++) {
//            String[] tokens = sc.nextLine().split("\\s+");
//            if (tokens[0].equals("root")) {
//                String value = tokens[1];
//                tree.makeRoot(value);
//            } else if (tokens[0].equals("add")) {
//                String parentValue = tokens[1];
//                String childValue = tokens[2];
//                String dir = tokens[3];
//                BNode<String> parent = findNode(tree.root, parentValue);
//                if (parent == null) {
//                    System.out.println("Error: Parent node with value " + parentValue + " not found.");
//                    continue;
//                }
//                int direction = dir.equals("LEFT") ? 1 : 2;
//                tree.addChild(parent, direction, childValue);
//            } else if (tokens[0].equals("ask")) {
//                System.out.println(treeDiameter(tree));
//            }
//        }
//
//    }
//
//    static BNode<String> findNode(BNode<String> node, String value) {
//        if (node == null) return null;
//        if (Objects.equals(node.info, value)) return node;
//        BNode<String> left = findNode(node.left, value);
//        BNode<String> right = findNode(node.right, value);
//        if (left != null) return left;
//        return right;
//    }
//
//    // Calculate the diameter of the binary tree
//    public static int treeDiameter(BTree<String> tree) {
//        if (tree == null || tree.root == null) return 0;
//        return diameter(tree.root);
//    }
//
//    private static int diameter(BNode<String> node) {
//        if (node == null) return 0;
//
//        // Get the height of left and right sub-trees
//        int leftHeight = height(node.left);
//        int rightHeight = height(node.right);
//
//        // Get the diameter of left and right sub-trees
//        int leftDiameter = diameter(node.left);
//        int rightDiameter = diameter(node.right);
//
//        // Return the maximum of the following:
//        // 1) Diameter of left sub-tree
//        // 2) Diameter of right sub-tree
//        // 3) Height of left sub-tree + height of right sub-tree + 1
//        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
//    }
//
//    private static int height(BNode<String> node) {
//        if (node == null) return 0;
//        return 1 + Math.max(height(node.left), height(node.right));
//    }

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

        public BNode(E info, BNode<E> left, BNode<E> right) {
            this.info = info;
            this.left = left;
            this.right = right;
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

        public void inorder() {
            System.out.print("INORDER: ");
            inorderR(root);
            System.out.println();
        }

        public void inorderR(BNode<E> n) {
            if (n != null) {
                inorderR(n.left); //levo
                System.out.print(n.info.toString() + " "); //koren
                inorderR(n.right); //desno
            }
        }

        public void preorder() {
            System.out.print("PREORDER: ");
            preorderR(root);
            System.out.println();
        }

        public void preorderR(BNode<E> n) {
            if (n != null) {
                System.out.print(n.info.toString() + " "); //koren
                preorderR(n.left); //levo
                preorderR(n.right); //desno
            }
        }

        public void postorder() {
            System.out.print("POSTORDER: ");
            postorderR(root);
            System.out.println();
        }

        public void postorderR(BNode<E> n) {
            if (n != null) {
                postorderR(n.left); //levo
                postorderR(n.right); //desno
                System.out.print(n.info.toString() + " "); //koren
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
//        }
//
//        public void preorderNonRecursive() {
//            ArrayStack<BNode<E>> s = new ArrayStack<BNode<E>>(100);
//            BNode<E> p = root;
//            System.out.print("PREORDER (nonrecursive): ");
//            if (p == null) return; // Handle an empty tree
//
//            s.push(p); // Start with the root node
//            while (!s.isEmpty()) {
//                p = s.pop(); // Process the node at the top of the stack
//                System.out.print(p.info.toString() + " ");
//
//                // Push the right child first so that the left child is processed next
//                if (p.right != null) {
//                    s.push(p.right);
//                }
//                if (p.left != null) {
//                    s.push(p.left);
//                }
//            }
//            System.out.println();
//        }
//
//        public void postorderNonRecursive() {
//            ArrayStack<BNode<E>> stack1 = new ArrayStack<BNode<E>>(100);
//            ArrayStack<BNode<E>> stack2 = new ArrayStack<BNode<E>>(100);
//            BNode<E> p = root;
//            System.out.print("POSTORDER (nonrecursive): ");
//            if (p == null) return; // Handle an empty tree
//
//            stack1.push(p);
//            while (!stack1.isEmpty()) {
//                p = stack1.pop();
//                stack2.push(p);
//
//                if (p.left != null) {
//                    stack1.push(p.left);
//                }
//                if (p.right != null) {
//                    stack1.push(p.right);
//                }
//            }
//
//            // Process nodes in stack2 to print them in post-order
//            while (!stack2.isEmpty()) {
//                p = stack2.pop();
//                System.out.print(p.info.toString() + " ");
//            }
//            System.out.println();
//        }

        public int prebrojVnatresni() {
            return prebrojVnatresniR(root);
        }

        int prebrojVnatresniR(BNode<E> node) {
            if (node == null) {//base case
                return 0;
            }
            int vnatresni = 0;

            if (node.left != null || node.right != null) { //ako ima dete -> ovoj e vnatresen
                vnatresni++;
            }
            vnatresni += prebrojVnatresniR(node.left) + prebrojVnatresniR(node.right);
            //proveri za dvete deca i gi
            //dodaj na finalniot rezultat

            return vnatresni;
        }

        public int prebrojLisja() {
            return prebrojLisjaR(root);
        }

        int prebrojLisjaR(BNode<E> node) {
            if (node == null) {//base case
                return 1;
            }

            if (node.left == null && node.right == null) { //ako daden jazol e list
                return 1;
            }
            return prebrojLisjaR(node.left) + prebrojLisjaR(node.right);
            //za site jazli, proveri gi decata dali se listovi
        }


        public int depth() {
            return depthR(root);
        }

        int depthR(BNode<E> node) {
            if (node == null) {//base case
                return 0;
            }
            if (node.left == null && node.right == null) {//ako e list, toj nema deca -> e 0
                return 0;
            }
            return 1 + Math.max(depthR(node.left), depthR(node.right));
            //segasniot ima edna dlabocina i kako se vrakja rekurzijata, se zema pogolemoto
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

        int maxDepthR(BNode<E> node, int visina) {
            if (node == null) return 0;

            if (node.left == null && node.right == null) {
                return visina;
            }

            return Math.max(maxDepthR(node.left, visina + 1), maxDepthR(node.right, visina + 1));
        }

        public int maxDepth() {
            return maxDepthR(root, 0);
        }

    }
}
