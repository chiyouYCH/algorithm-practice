package com.chiyou.algorithm.bit;

/**
 * 位运算练习
 * @author chiyou
 * @Description
 * @create 2022-09-30
 */
public class BitOperationTest {

    /**
     * 判断奇偶
     */
    public static void evenOrOdd(int num) {
        System.out.println("二进制:" + Integer.toBinaryString(num));
        if ((num&1) == 1) {
            System.out.println(num + "为奇数");
        }
        if ((num&1) == 0) {
            System.out.println(num + "为偶数");
        }
    }

    /**
     * 等量交换
     * @param
     */
    public static void swap(int x , int y) {
        System.out.println("当前x:"+ x +"当前y："+y);
        x = x^y;
        y = x^y;
        x = x^y;
        System.out.println("转换后x:"+ x +"转换后y："+y);
    }

    public static void main(String[] args) {
        evenOrOdd(10);
        swap(4,5);
    }
}
