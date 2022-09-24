package com.chiyou.algorithm.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
/**
 * 小米路由器密钥计算
 * @author chiyou
 * @Description
 * @create 2022-08-29
 */

public class Password {
    public static void main(String[] args) {
        // 1、加盐，这里需要反转
        String original = "d44fb0960aa0-a5e6-4a30-250f-6d2df50a";
        String[] split = original.split("-");
        String s = "";
        for (int i = 1; i <= split.length; i++) {
            s += split[split.length - i] + "-";
        }
        String salt = s.substring(0, s.length() - 1);

        // 2、取读输入的15位SN号码
        System.out.print("请输入15的SN号码：");
        Scanner scanner = new Scanner(System.in);
        String sn = scanner.nextLine();

        // 3、拼接，拼接方法为：sn+salt
        String str = sn + salt;

        // 4、java自带的方法进行md5加密
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(str.getBytes(StandardCharsets.UTF_8));
            String md5Str = new BigInteger(1, digest).toString(16);
            // 5、md5加密后的前8位即为密码
            String pass = md5Str.substring(0, 8);
            System.out.println("初始密码为：" + pass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
