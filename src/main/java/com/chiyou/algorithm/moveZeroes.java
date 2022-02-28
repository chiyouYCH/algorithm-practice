package com.chiyou.algorithm;

import java.util.Arrays;

/**
 * 题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @author chiyou
 * @Description
 * @create 2022-02-23
 */
public class moveZeroes {

    //2ms
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int startZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                if (startZeroIndex == -1) {
                    continue;
                }
                nums[startZeroIndex] = nums[i];
                startZeroIndex++;
                nums[i] = 0;
            }
            if (num==0 && startZeroIndex == -1) {
                startZeroIndex = i;
            }
        }

    }

    //优秀案例 一次判断 1ms
    public void moveZeroes1(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
//        int[] nums = new int[]{2,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
