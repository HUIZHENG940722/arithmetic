package com.hz.arithmetic.lettcode.test75;

/**
 * 反转字符串中的单词
 *
 * @author zhenghui
 * @since 2023/9/6
 */
public class Solution151  {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        int len = split.length, start = 0, end = len - 1;
        while (start < end) {
            String tmp = split[start];
            split[start] = split[end];
            split[end] = tmp;
            start++;
            end--;
        }
        return String.join(" ", split);
    }
}
