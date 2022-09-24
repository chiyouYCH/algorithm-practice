package com.chiyou.algorithm.treeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @author chiyou
 * @Description
 * @create 2022-07-19
 */
public class MaxDepth {

    public static int maxDepth(TreeNode root) {
        if (root== null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left,1);
        int right = maxDepth(root.right,1);
        int result = Math.max(left, right);
        return result;
    }

    private static int maxDepth(TreeNode child, int i) {
        if (child == null) {
            return i-1;
        }
        if (child.left == null && child.right == null) {
            return i;
        }
        i = i + 1;
        int left = maxDepth(child.left,i);
        int right = maxDepth(child.right,i);
        int result = Math.max(left, right);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val=1;
        TreeNode left = new TreeNode();
        left.val=21;
        root.left=left;
        TreeNode right = new TreeNode();
        right.val=21;
        root.right=right;

        int max = maxDepth(root);
        System.out.println(max);
    }
}
