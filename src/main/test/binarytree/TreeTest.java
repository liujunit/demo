package binarytree;

public class TreeTest {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node();
        tree.root.setiData(3);
        tree.root.setdData(4.1);
        tree.insert(5, 3.5);
        tree.insert(8, 2.03);
        tree.insert(1, 3.02);
        tree.insert(45, 2.012);
        tree.insert(4, 2.01);
        Node node = tree.findNode(1);
        node.showNode();
    }

}
