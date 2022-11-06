package com.ethan.course.lettcode.huawei;

/**
 * @Author zhenghui
 * @Description 回文数
 * @Date 2022/11/6
 */
public class Solution9 {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-121);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x).replace("-", "").replace("+", ""));
        String s = sb.reverse().toString();
        return sb.toString().equals(s);
    }
}
