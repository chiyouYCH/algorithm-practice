package com.chiyou.algorithm.array;

/**
 * 题目：给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * @author chiyou
 * @Description
 * @create 2022-02-28
 */
public class backspaceCompare {

    //算法不正确
    public static boolean backspaceCompare(String s, String t) {
        int sIndex = s.length()-1;
        int tIndex = t.length()-1;
        while (sIndex>=0 && tIndex >=0){
            if (sIndex < 0 || tIndex < 0) {
                return false;
            }
            sIndex = getCompareChar(s, sIndex);
            tIndex = getCompareChar(t,tIndex);
            if (sIndex < 0 && tIndex < 0) {
                return true;
            }
            if (sIndex < 0 || tIndex < 0) {
                return false;
            }
            if (s.charAt(sIndex) != t.charAt(tIndex)){
                return false;
            }
            sIndex--;
            tIndex--;
        }
        return true;
    }

    static int getCompareChar(String value,Integer index){

        int c = value.charAt(index);
        if (c == 35) {
            index = getCompareChar(value, index-1)-1;
            if (index > 0 && value.charAt(index) == 35) {
                index = getCompareChar(value,index-1)-1;
            }
        }
        return index;
    }

    //优秀案例1 ms
    public static boolean backspaceCompare1(String s, String t) {
        StringBuffer sbuffer = new StringBuffer();
        StringBuffer tbuffer = new StringBuffer();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) != '#') {
                sbuffer.append(s.charAt(i));
            } else if(sbuffer.length()>0) {
                sbuffer.deleteCharAt(sbuffer.length()-1);
            }
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            if (t.charAt(i) != '#') {
                tbuffer.append(t.charAt(i));
            } else if(tbuffer.length()>0) {
                tbuffer.deleteCharAt(tbuffer.length()-1);
            }
        }
        if (tbuffer.toString().equals(sbuffer.toString())) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        String a = "ab#c";
//        String b = "ad#c";
//        String a = "ab##";
//        String b = "c#d#";
        String a = "a##c";
        String b = "#a#c";
        System.out.println(backspaceCompare(a,b));
        System.out.println(backspaceCompare1(a,b));
    }
}
