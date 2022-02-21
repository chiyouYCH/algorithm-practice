package com.chiyou.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * @author chiyou
 * @Description
 * @create 2022-02-21
 */
public class removeDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slowIndex = 0;
        Set<Integer> exist = new HashSet<>();
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (!exist.contains(nums[fastIndex])) {
                nums[slowIndex++]=nums[fastIndex];
                exist.add(nums[fastIndex]);
            } else {
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4}; // 输入数组
        int[] expectedNums = new int[]{0,1,2,3,4}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用
        System.out.println(k+"-"+Arrays.toString(nums));
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
