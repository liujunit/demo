package binarytree;

/**
 * 二叉树
 */
public class Tree {

    public Node root;

    /**
     * 插入节点
     *
     * @param iData
     * @param dData
     */
    public void insert(int iData, Double dData) {
        Node newNode = new Node();
        newNode.setiData(iData);
        newNode.setdData(dData);
        //根节点是否存在判断
        if (root == null) {
            root = newNode;
        } else {
            Node parent = root;
            while (true) {
                if (parent.getiData() > iData) {
                    //左侧 不断向左查询 直到为null
                    Node leftNode = parent.getLeftNode();
                    if (leftNode == null) {
                        parent.setLeftNode(newNode);
                        return;
                    }
                    parent = leftNode;
                } else {
                    //右侧
                    Node rightNode = parent.getRightNode();
                    if (rightNode == null) {
                        parent.setRightNode(newNode);
                        return;
                    }
                    parent = rightNode;
                }
            }

        }
    }

    /**
     * 查找节点
     *
     * @return
     */
    public Node findNode(int key) {
        Node current = root;
        while (current.getiData() != key) {
            if (current.getiData() > key) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
        }
        return current;
    }

    /**
     * 查找最大值 最小值
     * @return
     */
    public Node[] findMValue() {
        Node min = root;
        Node max = root;
        //最小
        while (min.getLeftNode() != null) {
            min = min.getLeftNode();
        }
        //最大
        while (max.getRightNode() != null) {
            max = max.getRightNode();
        }
        Node[] nodes = {min, max};
        return nodes;
    }

}
