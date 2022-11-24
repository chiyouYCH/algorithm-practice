package com.chiyou.algorithm.treeNode;


/**
 * @author chiyou
 * @Description
 * @create 2022-11-24
 */
public class Tree {
    TreeNode root; // 根节点
    int size; // 树长度
    char[] data; // 数的数据

    public Tree(char[] data) {
        this.data = data;
        size = data.length;
        root = createTree(0);
    }

    public TreeNode createTree(int index) { // 采用递归生成二叉树
        if (index >= size)
            return null;
        if (data[index] == '0')
            return null;
        TreeNode TreeNode = new TreeNode(data[index]);
        TreeNode.setLeft(createTree(2 * index + 1));
        TreeNode.setRight(createTree(2 * index + 2));
        return TreeNode;
    }

    public void preShow(TreeNode TreeNode) { // 先序遍历
        if (TreeNode != null) {
            System.out.print(TreeNode.getVal() + " ");
            preShow(TreeNode.getLeft());
            preShow(TreeNode.getRight());
        }
    }

    public void middleShow(TreeNode TreeNode) { // 中序遍历
        if (TreeNode != null) {
            middleShow(TreeNode.getLeft());
            System.out.print(TreeNode.getVal() + " ");
            middleShow(TreeNode.getRight());
        }
    }

    public void backShow(TreeNode TreeNode) { // 后序遍历
        if (TreeNode != null) {
            backShow(TreeNode.getLeft());
            backShow(TreeNode.getRight());
            System.out.print(TreeNode.getVal() + " ");
        }
    }

    public TreeNode getRoot() { // 得到根节点
        return root;
    }
}
