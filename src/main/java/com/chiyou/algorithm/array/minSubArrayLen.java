package com.chiyou.algorithm.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * @author chiyou
 * @Description
 * @create 2022-03-02
 */
public class minSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums){
        int startIndex = 0;
        int endIndex = 1;
        int total = nums[0];
        int result = nums.length+1;
        if (nums[0] > target) {
            return 1;
        } else if (nums[0]>target) {
            total = 0;
        }

        while (endIndex<nums.length){

            total = total+nums[endIndex];
            while (total>=target) {
                if (endIndex-startIndex+1<=result) {
                    result = endIndex-startIndex+1;
                }
                total = total-nums[startIndex];
                startIndex++;
            }
            endIndex++;

        }

        return result == nums.length+1?0 : result;
    }

    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 6;
        int[] nums = new int[]{10,2,3};
        int i = minSubArrayLen(target, nums);
        System.out.println(i);
    }
}
