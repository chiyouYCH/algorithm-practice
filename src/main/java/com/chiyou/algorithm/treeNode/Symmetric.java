package com.chiyou.algorithm.treeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @author chiyou
 * @Description
 * @create 2022-11-24
 */
public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
