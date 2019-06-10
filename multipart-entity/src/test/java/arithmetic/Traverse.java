package arithmetic;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

public class Traverse {

    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("data", data)
                    .append("left", left)
                    .append("right", right)
                    .toString();
        }
    }

    public void printNode(Node node) {
        System.out.print(node.getData() + " ");
    }

    /**
     * 先序递归
     * （找到根，先记录根）
     * @param node 根节点
     */
    public void perOrder(Node node) {
        if (node == null) {
            return;
        }
        printNode(node);
        perOrder(node.getLeft());
        perOrder(node.getRight());
    }

    /**
     * 中序递归
     * （先记录根的所有左子）
     * @param node 根节点
     */
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        printNode(node);
        inOrder(node.getRight());
    }

    /**
     * 后序递归
     * （先记录根的所有子节点）
     * @param node 根节点
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        printNode(node);
    }

    @Test
    public void traverse01() {
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, node7, null);
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, null);
        Node node3 = new Node(3, node5, node6);
        Node node2 = new Node(2, null, node4);
        Node root = new Node(1, node2, node3);

        // 前序1,2,4,3,5,6,7 根左右
        System.out.println("先序遍历");
        perOrder(root);
        // 中序2,4,1,5,3,7,6 左根右
        System.out.println("\n中序遍历");
        inOrder(root);
        // 后序4,2,5,7,6,3,1 左右根
        System.out.println("\n后序遍历");
        postOrder(root);

    }


}
