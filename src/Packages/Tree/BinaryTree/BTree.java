package Packages.Tree.BinaryTree;

import Packages.Hashing.SLLNode;
import Zadaci.NiziListi.SLL;

public class BTree<E> {

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

    public void inorderNonRecursive() {
        ArrayStack<BNode<E>> s = new ArrayStack<BNode<E>>(100);
        BNode<E> p = root;
        System.out.print("INORDER (nonrecursive): ");

        while (true) {
            // pridvizuvanje do kraj vo leva nasoka pri sto site koreni
            // na potstebla se dodavaat vo magacin za podocnezna obrabotka
            while (p != null) {
                s.push(p);
                p = p.left;
            }

            // ako magacinot e prazen znaci deka stebloto e celosno izminato
            if (s.isEmpty())
                break;

            p = s.peek();
            // pecatenje (obrabotka) na jazelot na vrvot od magacinot
            System.out.print(p.info.toString() + " ");
            // brisenje na obraboteniot jazel od magacinot
            s.pop();
            // pridvizuvanje vo desno od obraboteniot jazel i povtoruvanje na
            // postapkata za desnoto potsteblo na jazelot
            p = p.right;

        }
        System.out.println();
    }

    public void preorderNonRecursive() {
        ArrayStack<BNode<E>> s = new ArrayStack<BNode<E>>(100);
        BNode<E> p = root;
        System.out.print("PREORDER (nonrecursive): ");
        if (p == null) return; // Handle an empty tree

        s.push(p); // Start with the root node
        while (!s.isEmpty()) {
            p = s.pop(); // Process the node at the top of the stack
            System.out.print(p.info.toString() + " ");

            // Push the right child first so that the left child is processed next
            if (p.right != null) {
                s.push(p.right);
            }
            if (p.left != null) {
                s.push(p.left);
            }
        }
        System.out.println();
    }

    public void postorderNonRecursive() {
        ArrayStack<BNode<E>> stack1 = new ArrayStack<BNode<E>>(100);
        ArrayStack<BNode<E>> stack2 = new ArrayStack<BNode<E>>(100);
        BNode<E> p = root;
        System.out.print("POSTORDER (nonrecursive): ");
        if (p == null) return; // Handle an empty tree

        stack1.push(p);
        while (!stack1.isEmpty()) {
            p = stack1.pop();
            stack2.push(p);

            if (p.left != null) {
                stack1.push(p.left);
            }
            if (p.right != null) {
                stack1.push(p.right);
            }
        }

        // Process nodes in stack2 to print them in post-order
        while (!stack2.isEmpty()) {
            p = stack2.pop();
            System.out.print(p.info.toString() + " ");
        }
        System.out.println();
    }

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