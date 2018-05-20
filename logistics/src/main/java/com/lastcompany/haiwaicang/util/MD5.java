package com.lastcompany.haiwaicang.util;

import java.security.MessageDigest;


public class MD5 {
    private static char[] HexCode = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g'};

    public MD5() {
    }

    public static String md5(String s) {
        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            byte[] var3 = md.digest(s.getBytes());
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                byte b = var3[var5];
                sb.append(HexCode[b & 15]);
                sb.append(HexCode[b >>> 4 & 15]);
            }

            return sb.toString();
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }

    public static void main(String[] args) {
        System.out.println(md5("123!"));
    }
}
