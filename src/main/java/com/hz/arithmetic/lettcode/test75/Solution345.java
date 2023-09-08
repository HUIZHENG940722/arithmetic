package com.hz.arithmetic.lettcode.test75;

/**
 * 反转字符串中的元音字母
 *
 * @author zhenghui
 * @since 2023/9/6
 */
public class Solution345 {
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int start = 0, end = len - 1;
        while (start < end) {
            while (start < end && !isVowel(charArray[start])) {
                start++;
            }
            while (start < end && !isVowel(charArray[end])) {
                end--;
            }
            if (start<end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            } else {
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            result.append(c);
        }
        return result.toString();
    }

    private Boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(String.valueOf(c));
    }
}
