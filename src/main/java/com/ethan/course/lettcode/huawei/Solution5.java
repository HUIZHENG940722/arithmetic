package com.ethan.course.lettcode.huawei;

/**
 * @Author zhenghui
 * @Description 最长回文子串
 * @Date 2022/10/26
 */
public class Solution5 {
    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        int resultLen = 0;
        String result = null;
        for (int i = 0; i < len; i++) {
            int kz = 2 * (i + 1);
            int zz = 2 * (len - i);
            int f = 0;
            if (kz < zz) {
                f = kz;
            } else {
                f = zz;
            }
            if (f <= resultLen) {
                continue;
            } else {
                int indexLen = longestPalindromeByIndex(s, i);
                if (indexLen > resultLen) {
                    resultLen = indexLen;
                    if (resultLen % 2 == 0) {
                        result = s.substring(i + 1 - resultLen / 2, i + resultLen / 2 + 1);
                    } else {
                        result = s.substring(i - resultLen / 2, i + resultLen / 2 + 1);
                    }
                }
            }
        }
        return result;
    }

    private static int longestPalindromeByIndex(String s, int index) {
        int len = s.length();
        // 回文串长度为单数
        int d = 1;
        for (int i = index - 1, j = index + 1; i >= 0 && j < len; i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            } else {
                d += 2;
            }
        }
        // 回文串的长度为双数
        int ss = 0;
        for (int i = index, j = index + 1; i >= 0 && j < len; i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            } else {
                ss += 2;
            }
        }
        if (d > ss) {
            return d;
        } else {
            return ss;
        }
    }
}
