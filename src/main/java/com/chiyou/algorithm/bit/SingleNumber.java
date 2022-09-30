package com.chiyou.algorithm.bit;

/**
 * 给你一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * @author chiyou
 * @Description
 * @create 2022-09-30
 */
public class SingleNumber {

    /**
     * 1.对所有值进行异或运算 ，得到只有单次出现的两个值 a^b
     * 2.由于异或规则是二进制相同为0，不同为1，取最低位为1的值既a、b两个值不同的地方
     * 3.把所有值对这个最低位进行与运算，这样两个值一定会存在两个不同的区间，而相同的值因为会在同一个区间，异或运算就抵消掉了，每个区间就剩下唯一值
     * @param nums
     * @return
     */
    public static int[] singleNumber(int[] nums) {
        // 通过异或操作，最终结果等于两个单次出现的元素的异或值。
        int filterResult = 0;
        for (int num : nums) {
            filterResult ^= num;
        }
        System.out.println(Integer.toBinaryString(filterResult));
        System.out.println(Integer.toBinaryString(-filterResult));
        // 计算最低位为1的值
        int mask = filterResult & (-filterResult);
        System.out.println("mask:"+Integer.toBinaryString(mask));
        // 以首个为1的二进制位将原数组分为两个部分并分别进行异或运算，最终结果为两个题解。
        int[] ans = new int[2];
        for (int num : nums) {
//            System.out.println("值："+num+"二进制："+Integer.toBinaryString(num) +" num & mask:"+Integer.toBinaryString(num & mask));
            if ( (num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        System.out.println(Integer.toBinaryString(ans[0])+"---"+Integer.toBinaryString(ans[1]));
        System.out.println(ans[0]+"---"+ans[1]);

        return ans;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,1,3,2,5};
        singleNumber(num);
    }
}
