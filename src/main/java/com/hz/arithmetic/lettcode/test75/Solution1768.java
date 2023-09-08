package com.hz.arithmetic.lettcode.test75;

/**
 * 交替合并字符串
 *
 * @author zhenghui
 * @since 2023/9/4
 */
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int index = 0, index1 = 0, index2 = 0, len1 = word1.length(), len2 = word2.length();
        StringBuilder result = new StringBuilder();
        while (index1 < len1 && index2 < len2) {
            if (index % 2 == 0) {
                result.append(word1.charAt(index1));
                index1++;

            } else {
                result.append(word2.charAt(index2));
                index2++;
            }
            index++;
        }
        if (index1<len1) {
            result.append(word1.substring(index1));
        }
        if (index2<len2) {
            result.append(word2.substring(index2));
        }
        return result.toString();
    }
}
