package com.hz.arithmetic.lettcode.test100;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 最小覆盖子串
 *
 * @author zhenghui
 * @since 2023/11/20
 */
public class Solution76 {

  /**
   * 滑动窗口
   *
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    int lenT = t.length(), lenS = s.length();
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    for (int i = 0; i < lenT; i++) {
      char c = t.charAt(i);
      ori.put(c, ori.getOrDefault(c, 0) + 1);
    }
    int l = 0, r = -1, len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
    while (r < lenS) {
      ++r;
      if (r < lenS && ori.containsKey(s.charAt(r))) {
        cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
      }
      while (check(ori, cnt) && l <= r) {
        if (r - l + 1 < len) {
          len = r - l + 1;
          ansL = l;
          ansR = l + len;
        }
        if (ori.containsKey(s.charAt(l))) {
          cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
        }
        ++l;
      }
    }
    return ansL == -1 ? "" : s.substring(ansL, ansR);
  }

  private boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt) {
    for (Entry<Character, Integer> next : ori.entrySet()) {
      Character key = next.getKey();
      Integer val = next.getValue();
      if (cnt.getOrDefault(key, 0) < val) {
        return false;
      }
    }
    return true;
  }
}
