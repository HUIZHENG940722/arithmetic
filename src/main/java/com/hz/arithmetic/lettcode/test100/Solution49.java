package com.hz.arithmetic.lettcode.test100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 *
 * @author zhenghui
 * @since 2023/11/11
 */
public class Solution49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String s = String.valueOf(charArray);
      if (!map.containsKey(s)) {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(s, list);
      } else {
        List<String> list = map.get(s);
        list.add(str);
        map.put(s, list);
      }
    }
    List<List<String>> result = new ArrayList<>();
    map.forEach((key, val) -> {
      result.add(val);
    });
    return result;
  }
}
