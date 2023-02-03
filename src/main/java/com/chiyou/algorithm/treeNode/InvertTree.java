package com.chiyou.algorithm.treeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @author chiyou
 * @Description
 * @create 2023-02-02
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.right = invertTree(root.right);
        root.left = invertTree(root.left);
        TreeNode mid = root.right;
        root.right = root.left;
        root.left = mid;
        return root;
    }
}
