package com.chiyou.algorithm.treeNode;

/**
 * 使用chatgpt生成平衡二叉树
 * @author chiyou
 * @Description
 * @create 2023-01-31
 */
public class BinarySearchTree {

    private Node root;

    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, int data) {

        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data)
            node.left = insertRec(node.left, data);
        else if (data > node.data)
            node.right = insertRec(node.right, data);

        return node;
    }
}
