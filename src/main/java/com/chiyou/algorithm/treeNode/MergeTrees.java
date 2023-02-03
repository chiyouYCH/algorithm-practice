package com.chiyou.algorithm.treeNode;

/**
 * 当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 * 链接：https://leetcode.cn/problems/merge-two-binary-trees
 * @author chiyou
 * @Description
 * @create 2023-02-02
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode result = new TreeNode();
        if (root1 == null && root2 == null) {
            return null;
        }
        result.right=mergeTrees(root1==null?null:root1.right,root2==null?null:root2.right);
        result.left=mergeTrees(root1==null?null:root1.left,root2==null?null:root2.left);
        int val1 = root1 == null ? 0 : root1.val;
        int val2 = root2 == null ? 0 : root2.val;
        result.val= val1 + val2;
        return result;
    }

    //案例
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        TreeNode result = new TreeNode();
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        result.right=mergeTrees(root1.right,root2.right);
        result.left=mergeTrees(root1.left,root2.left);
        int val1 = root1 == null ? 0 : root1.val;
        int val2 = root2 == null ? 0 : root2.val;
        result.val= val1 + val2;
        return result;
    }
}
