package com.chiyou.algorithm.treeNode;

/**平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * @author chiyou
 * @Description
 * @create 2022-11-04
 */
public class IsBalanced {

    //递归分析：结束条件：子节点为空，或者子节点已经不平衡了 返回内容：子节点高度，是否平衡，递归动作：计算子最高节点高度，判断是否平衡
    public static boolean isBalanced (TreeNode treeNode) {
        return getReturnNode(treeNode).isB;
    }

    private static ReturnNode getReturnNode(TreeNode treeNode) {
        if (treeNode == null) {
            return new ReturnNode(0,true);
        }
        ReturnNode leftNode = getReturnNode(treeNode.left);
        ReturnNode rightNode = getReturnNode(treeNode.right);
        if (!(leftNode.isB && rightNode.isB) || Math.abs(leftNode.depth - rightNode.depth) > 1) {
            return new ReturnNode(0,false);
        }
        return new ReturnNode(Math.max(leftNode.depth,rightNode.depth)+1,true);
    }


    private static class ReturnNode{
        boolean isB;
        int depth;
        public ReturnNode(int depth, boolean isB){
            this.isB = isB;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[] {'1', '2', '3', '4', '0', '5', '6', '7', '8', '0', '0', '9', 'A'};
        Tree tree = new Tree(chars);
        boolean balanced = isBalanced(tree.getRoot());
        System.out.println("结果"+balanced);
    }
}
