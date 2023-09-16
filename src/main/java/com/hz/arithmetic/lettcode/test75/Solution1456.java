package com.hz.arithmetic.lettcode.test75;

/**
 * 定长子串中元音的最大数目
 *
 * @author zhenghui
 * @since 2023/9/15
 */
public class Solution1456 {

  public int maxVowels(String s, int k) {
    int len = s.length(), left = 0, right = k, ans = 0, max;
    String tmp = "aeiouAEIOU";
    for (int i = 0; i < k; i++) {
      char c = s.charAt(i);
      if (tmp.contains(String.valueOf(c))) {
        ans++;
      }
    }
    max = ans;
    while (right < len) {
      ans = ans - (tmp.contains(String.valueOf(s.charAt(left))) ? 1 : 0) + (
          tmp.contains(String.valueOf(s.charAt(right))) ? 1 : 0);
      max = Math.max(max, ans);
      left++;
      right++;
    }
    return max;
  }
}
