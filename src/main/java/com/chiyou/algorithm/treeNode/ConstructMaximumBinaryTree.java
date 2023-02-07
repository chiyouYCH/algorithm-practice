package com.chiyou.algorithm.treeNode;

/**
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。

 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * @author chiyou
 * @Description
 * @create 2023-02-02
 */
public class ConstructMaximumBinaryTree {


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums,0,nums.length-1);
    }

    private static TreeNode maxTree(int[] nums, int start, int end) {
        if (nums == null) {
            return null;
        }
        if (start > end) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        int maxIndex = findMaxIndex(nums,start,end);
        treeNode.val = nums[maxIndex];
        treeNode.left = maxTree(nums,start,maxIndex-1);
        treeNode.right = maxTree(nums,maxIndex+1,end);
        //终止条件没想好，导致多出来的逻辑
//        if (maxIndex == start) {
//            treeNode.right = maxTree(nums,maxIndex+1,end);
//        } else if (maxIndex == end) {
//            treeNode.left = maxTree(nums,start,maxIndex-1);
//        } else {
//            treeNode.left = maxTree(nums,start,maxIndex-1);
//            treeNode.right = maxTree(nums,maxIndex+1,end);
//        }
        return treeNode;
    }

    private static int findMaxIndex(int[] nums, int start, int end) {
        int result = 0;
        int maxVal = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i]>=maxVal) {
                result = i;
                maxVal = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(num);
        System.out.println(treeNode.toString());
    }
}
