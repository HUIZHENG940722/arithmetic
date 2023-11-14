package com.hz.arithmetic.lettcode.test100;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author zhenghui
 * @since 2023/11/14
 */
public class Solution3 {

  public int lengthOfLongestSubstring(String s) {
    char[] charArray = s.toCharArray();
    int left = 0, right = 0, len = s.length(), result = 0;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < len; i++) {
      char tmp = charArray[i];
      if (set.contains(tmp)) {
        result = Math.max(result, right - left);
        int l = s.indexOf(tmp, left) + 1;
        for (int j = left; j < l - 1; j++) {
          set.remove(charArray[j]);
        }
        left = l;
      } else {
        set.add(tmp);
      }
      right++;
    }
    result = Math.max(result, right - left);
    return result;
  }
}
