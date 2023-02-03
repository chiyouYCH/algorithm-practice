package com.chiyou.algorithm.treeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * @author chiyou
 * @Description
 * @create 2023-02-02
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int result = 0;
        if (root.left == null) {
            result = minDepth(root.right);
        } else if (root.right == null) {
            result = minDepth(root.left);
        } else {
            int rightDepth = minDepth(root.right);
            int leftDepth = minDepth(root.left);
            result = Math.min(rightDepth, leftDepth);
        }
        return 1+result;
    }
}
