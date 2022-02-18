package com.chiyou.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author chiyou
 * @Description
 * @create 2022-02-18
 */
public class lengthOfLongestSubstring {

    public static int getMaxLength(String value){
        int start = 0;
        int nes = 0;
        int length = value.length();
        Map<Character,Integer> exist = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            if (exist.containsKey(c)) {
                start = Math.max(start,exist.get(c)+1);
            }
            exist.put(c,i);
            nes = Math.max(nes,i-start+1);
        }
        return nes;
    }

    /**
     * 优秀案例 把字符串转化为ASCII数据结构，从遍历变为索引查询
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        String value = "abcabcbbwerwertwertewrgwrtrrrr";
        int maxLength = getMaxLength(value);
        System.out.println("最大长度"+maxLength);
        int i1 = lengthOfLongestSubstring(value);
        System.out.println("最大长度"+i1);
    }
}
