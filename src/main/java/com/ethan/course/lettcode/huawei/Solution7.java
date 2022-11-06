package com.ethan.course.lettcode.huawei;

/**
 * @Author zhenghui
 * @Description 整数反转
 * @Date 2022/11/2
 */
public class Solution7 {
    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        try {
            if (x >= 0) {
                return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
            } else {
                return -Integer.parseInt(new StringBuilder(String.valueOf(x).substring(1)).reverse().toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
