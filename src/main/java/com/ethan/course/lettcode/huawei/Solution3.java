package com.ethan.course.lettcode.huawei;

/**
 * @Author zhenghui
 * @Description 无重复的最长子串
 * @Date 2022/10/24
 */
public class Solution3 {

    public static void main(String[] args) {
        int bbbbb = lengthOfLongestSubstring("abcb");
        System.out.println(bbbbb);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 最长子串的首位置索引i，末位置下一位索引j
        int i = 0, j = 1;
        int len = s.length();
        int result = 1;
        for (; j < len; j++) {
            char c = s.charAt(j);
            int index = s.indexOf(c, i);
            if (index < j) {
                if (j - i > result) {
                    result = j - i;
                }
                i = index + 1;
            } else if (j == len - 1) {
                if (j - i + 1 > result) {
                    result = j - i + 1;
                }
            }
        }
        return result;
    }
}
