package com.chiyou.algorithm.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.viterbi.FinalSeg;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chiyou
 * @Description
 * @create 2022-09-19
 */
public class EncodeTest {
    private static String[] charsetArr = {"UTF-8","GB18030","GB2312","GBK","Windows-1252","ISO8859-1","Big5","Shift_Jis"};

    public static void testAllCharset(String text) throws UnsupportedEncodingException {
        if (text == null || text.length() == 0) {
            System.out.println("文本不能为空");
            return;
        }

        System.out.println("假设当前编码       假设原始编码          编码后的内容");
        printSeparator();

        for (String curCharset : charsetArr) {
            byte[] btArr = text.getBytes(curCharset);
            for (String originCharset : charsetArr) {
                if (originCharset.equals(curCharset)) {
                    continue;
                }
                String encodeText = new String(btArr,originCharset);
                printTable(curCharset, originCharset, encodeText);
            }
            printSeparator();
        }
    }

    private static void printSeparator() {
        System.out.println("--------------------------------------------------------");
    }

    private static void printTable(String curCharset, String originCharset, String encodeText) {
        System.out.print(curCharset);
        for (int i = 0; i < 15 - curCharset.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|   " + originCharset);
        for (int i = 0; i < 16 - originCharset.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|     " + encodeText);
    }

    /**
     * 优先实现，而不是完美完善
     * 1全是乱码的时候，2一般乱码，一般不乱码
     * 2.不考虑必须全部一致，
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        //测试乱码
        testAllCharset("醱勤掩\uF847极\uF815鏢厗腔峉儂ㄛ\uF815蠅眒冪羶衄域楊疑疑汜湔狟\uF7EF賸ㄛ憩砉岆醱勤骨痌腔瓷\uF815珨欴ㄛ疑疑華徹藩珨毞ㄛ毀奧汜堤賸拸癹洷咡﹝");
//        stringToUnicode("服务器内部错");
//        JiebaSegmenter segmenter = new JiebaSegmenter();
//        List<String> result = segmenter.sentenceProcess("鏈嶅姟鍣ㄥ唴閮ㄩ敊璇");
//        System.out.println(result);
//        List<String> result1 = segmenter.sentenceProcess("锘挎槬鐪犱笉瑙夋檽锛屽澶勯椈鍟奸笩");
//        System.out.println(result1);
//        List<String> result2 = segmenter.sentenceProcess("服务器内部错");
//        System.out.println(result2);
        printText("醱勤掩\uF847极\uF815鏢厗腔峉儂ㄛ\uF815蠅眒冪羶衄域楊疑疑汜湔狟\uF7EF賸ㄛ憩砉岆醱勤骨痌腔瓷\uF815珨欴ㄛ疑疑華徹藩珨毞ㄛ毀奧汜堤賸拸癹洷咡﹝");
        if ("锘挎槬鐪犱笉瑙夋檽锛屽澶勯椈鍟奸笩".matches("[\\u4E00-\\u9FA5]+")) {
            System.out.println("这是中文");
        } else {
            System.out.println("这不是中文");
        }
    }

    private static void uniCondeNumber(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]+"-");
        }
    }

    /**
     * 1.校验输入是否本身为正常
     * 2.汉字： [0x4e00,0x9fa5]（或十进制 [19968,40869]） 数字： [0x30,0x39]（或十进制 [48, 57]） 小写字母： [0x61,0x7a]（或十进制 [97, 122]）
     * @param text
     */
    private static void printText(String text) throws UnsupportedEncodingException {
        if (text == null || text.length() == 0) {
            System.out.println("文本不能为空");
            return;
        }
        List<String> usualList = getUsualList();
        int resultMax = 0;
        int count1 = 500;
        String oldCharset = null;
        String newCharset = null;
        String result = new String();
        JiebaSegmenter segmenter = new JiebaSegmenter();
        for (String curCharset : charsetArr) {
            byte[] btArr = text.getBytes(curCharset);
            for (String originCharset : charsetArr) {
                if (originCharset.equals(curCharset)) {
                    continue;
                }
                byte[] newArr = new byte[btArr.length];
                int i = 0;
                if  (curCharset.equals("Windows-1252") && originCharset.equals("GB18030")) {
                    System.out.println("----");
                }
                String newStr = new String(btArr, originCharset);
                String[] singleWord = newStr.split("");
                List<String> collect = Arrays.stream(singleWord).filter(s -> usualList.contains(s)).collect(Collectors.toList());


//                List<String> result2 = segmenter.sentenceProcess(newStr);
//                List<String> collect = result2.stream().filter(s -> s.length() > 1 && !usualList.contains("�") ).collect(Collectors.toList());
                if (collect != null &&   resultMax<collect.size()) {
                    System.out.println(collect);
                    result = newStr;
                    resultMax = collect.size();
//                    count1 = count2;
                }

//                String[] split = newStr.split("");
//                for (String single : split) {
////                    if (!emitList.contains(single) && single.matches("[\\u4E00-\\u9FA5]+")) {
////                        i++;
////                    }
//                    char[] chars = single.toCharArray();
//                    for (char aChar : chars) {
//                        if (isChinese(aChar)) {
//                            i++;
//                        }
//                    }
//                }
//                if (resultMax<i) {
//                    oldCharset = curCharset;
//                    newCharset = originCharset;
//                    result = newStr;
//                    resultMax = i;
//                }
            }
        }
//        if (oldCharset == null) {
//            System.out.println("数据无法恢复");
//        }
        System.out.println("解析结果："+result);
    }

    // 根据Unicode编码完美的判断中文汉字和符号
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
    // 完整的判断中文汉字和符号
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getUsualList() {
        InputStream is = EncodeTest.class.getResourceAsStream("/word.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            List<String> result = new ArrayList<>();

            while(br.ready()) {
                String line = br.readLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    result.add(word);
                }
            }
            return result;
        } catch (IOException var20) {
            System.err.println(String.format(Locale.getDefault(), "%s: load model failure!", "/prob_emit.txt"));
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException var19) {
                System.err.println(String.format(Locale.getDefault(), "%s: close failure!", "/prob_emit.txt"));
            }
        }
        return null;
    }

    public static List<String> getEmitList() {
        InputStream is = EncodeTest.class.getResourceAsStream("/prob_emit.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            List<String> emit = new ArrayList<>();

            while(br.ready()) {
                String line = br.readLine();
                String[] tokens = line.split("\t");
                if (tokens.length != 1) {
                    emit.add(tokens[0]);
                }
            }
            return emit;
        } catch (IOException var20) {
            System.err.println(String.format(Locale.getDefault(), "%s: load model failure!", "/prob_emit.txt"));
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException var19) {
                System.err.println(String.format(Locale.getDefault(), "%s: close failure!", "/prob_emit.txt"));
            }
        }
        return null;
    }

    /*
     * unicode编码
     */
    public static String stringToUnicode(String str) {
        char[] utfBytes = str.toCharArray();
        StringBuilder unicodeBytes = new StringBuilder();
        for (char utfByte : utfBytes) {
            String hexB = Integer.toHexString(utfByte);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes.append("\\u").append(hexB);
        }
        System.out.println(unicodeBytes.toString());
        return unicodeBytes.toString();
    }
}
