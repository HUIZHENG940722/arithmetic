package com.hz.arithmetic.lettcode.test75;

/**
 * 字符串的最大公因子
 *
 * @author zhenghui
 * @since 2023/9/4
 */
public class Solution1701 {

    public static void main(String[] args) {
        String str1 = "ABC", str2 = "ABCABC";
        String s = gcdOfStrings(str1, str2);
        System.out.println("s = " + s);
    }

    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length(), min = Math.min(len1, len2);
        String str = len2 > len1 ? str1 : str2;
        for (int i = min; i > 0; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String result = str.substring(0, i);
                if (subByStr(str1, result, len1 / i) && subByStr(str2, result, len2 / i)) {
                    return result;
                }
            }
        }
        return "";
    }

    private static Boolean subByStr(String str1, String str2, Integer sub) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sub; i++) {
            result.append(str2);
        }
        return result.toString().equals(str1);
    }
}
