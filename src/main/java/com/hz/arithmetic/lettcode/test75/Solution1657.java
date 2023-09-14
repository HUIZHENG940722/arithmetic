package com.hz.arithmetic.lettcode.test75;

import java.util.HashMap;
import java.util.Map;

/**
 * 确定两个字符串是否接近
 *
 * @author zhenghui
 * @since 2023/9/14
 */
public class Solution1657 {

  public boolean closeStrings(String word1, String word2) {
    int len1 = word1.length(), len2 = word2.length();
    if (len1 != len2) {
      return false;
    }
    Map<Character, Character> one2Two = new HashMap<>(), two2One = new HashMap<>();
    for (int i = 0; i < len1; i++) {
      char c1 = word1.charAt(i), c2 = word2.charAt(i);
      if (one2Two.containsKey(c1)) {
        if (one2Two.get(c1) != c2) {
          return false;
        }
      } else {
        one2Two.put(c1, c2);
      }
      if (two2One.containsKey(c2)) {
        if (two2One.get(c2) != c1) {
          return false;
        }
      } else {
        two2One.put(c2, c1);
      }
    }
    return true;
  }
}
