package com.chiyou.algorithm;

import java.util.Arrays;

/**
 * 题目：给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * @author chiyou
 * @Description
 * @create 2022-03-02
 */
public class sortedSquares {

    /**
     * 直接看了答案
     * @param nums
     * @return
     */
    public static int[] sortedSquares (int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int[] result = new int[nums.length];
        for (int i = result.length-1; i >= 0; i--) {
            int startNum = nums[start] * nums[start];
            int endNum = nums[end]*nums[end];
            if (startNum >= endNum) {
                result[i] =startNum;
                start++;
            } else {
                result[i] = endNum;
                end--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] num = new int[]{-4,-1,0,3,10};
        int[] num = new int[]{-7,-3,2,3,11};
        int[] result = sortedSquares(num);
        System.out.println(Arrays.toString(result));
    }
}
