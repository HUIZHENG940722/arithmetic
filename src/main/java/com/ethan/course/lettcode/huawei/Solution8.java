package com.ethan.course.lettcode.huawei;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author zhenghui
 * @Description 字符串转换整数
 * @Date 2022/11/2
 */
public class Solution8 {

    public static void main(String[] args) {
        String s = "words and 987";
        int i = myAtoi(s);
        System.out.println(i);
    }

    public static int myAtoi(String s) {
        Pattern compile = Pattern.compile("(-?\\d+)");
        Matcher matcher = compile.matcher(s);
        String group = null;
        while (matcher.find()) {
            group = matcher.group();
        }
        if (group.startsWith("-")) {
            return -Integer.parseInt(group.substring(1));
        } else {
            return Integer.parseInt(group);
        }
    }
}
