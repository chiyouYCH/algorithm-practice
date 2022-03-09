package com.chiyou.algorithm.array;

import java.util.Arrays;

/**
 * 题目：给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 * @author chiyou
 * @Description
 * @create 2022-03-08
 */
public class generateMatrix {

    //核心问题写好循环，注意开闭区间
    public static int[][] generateMatrix(int n) {
        int length = n;

        int startX = 0;
        int starty = 0;

        int loop = n/2;
        int count = 1;
        int[][] result = new int[n][n];
        while (loop>0) {
            int x = startX;
            int y = starty;

            for (;y<length-1;y++){
                result[x][y] = count++;
            }

            for (;x<length-1;x++) {
                result[x][y] = count++;
            }

            for (;y > starty;y--) {
                result[x][y] = count++;
            }

            for (;x > startX;x--){
                result[x][y] = count++;
            }
            length = length - 1;
            startX+=1;
            starty+=1;
            loop--;

        }
        if (n%2>0) {
            int i = n / 2;
            result[i][i] = count++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] result = generateMatrix(6);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
