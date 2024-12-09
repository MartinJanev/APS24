package Packages.Tree.BinaryTree;

public class BTreeTest {

    public static void main(String[] args) {
        BNode<Character> a, b, c;
        BTree<Character> tree = new BTree<Character>('F');
        a = tree.addChild(tree.root, BNode.LEFT, 'D');
        b = tree.addChild(a, BNode.LEFT, 'B');
        c = tree.addChild(b, BNode.LEFT, 'A');
        c = tree.addChild(b, BNode.RIGHT, 'C');
        c = tree.addChild(a, BNode.RIGHT, 'E');
        a = tree.addChild(tree.root, BNode.RIGHT, 'G');
        b = tree.addChild(a, BNode.RIGHT, 'I');
        c = tree.addChild(b, BNode.LEFT, 'H');
        c = tree.addChild(b, BNode.RIGHT, 'J');
        
        tree.inorder();
        tree.preorder();
        tree.postorder();
        tree.inorderNonRecursive();
        tree.preorderNonRecursive();
        tree.postorderNonRecursive();

        System.out.println("Brojot na vnatresni jazli e " + tree.prebrojVnatresni());
        System.out.println("Brojot na listovi e " + tree.prebrojLisja());
        System.out.println("Dlabocinata na drvoto e " + tree.depth());

        tree.mirror();
        tree.inorder();
    }

}
