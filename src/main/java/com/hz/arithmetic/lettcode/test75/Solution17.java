package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * @author zhenghui
 * @since 2023/9/11
 */
public class Solution17 {

  private static final Map<Integer, List<Character>> MAP = new HashMap<>();

  static {
    MAP.put(2, Arrays.asList('a', 'b', 'c'));
    MAP.put(3, Arrays.asList('d', 'e', 'f'));
    MAP.put(4, Arrays.asList('g', 'h', 'i'));
    MAP.put(5, Arrays.asList('j', 'k', 'l'));
    MAP.put(6, Arrays.asList('m', 'n', 'o'));
    MAP.put(7, Arrays.asList('p', 'q', 'r', 's'));
    MAP.put(8, Arrays.asList('t', 'u', 'v'));
    MAP.put(9, Arrays.asList('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations(String digits) {

    List<String> results = new ArrayList<>();
    StringBuilder result = new StringBuilder();
    if (digits.isEmpty()) {
      return results;
    }
    letterCombinations(results, digits, 0, result);
    return results;
  }

  private void letterCombinations(List<String> results, String digits, int index,
      StringBuilder result) {
    if (index >= digits.length()) {
      results.add(result.toString());
      return;
    }
    int i = digits.charAt(index) - '0';
    List<Character> characters = MAP.get(i);
    for (Character character : characters) {
      result.append(character);
      letterCombinations(results, digits, index + 1, result);
      result.deleteCharAt(index);
    }
  }
}
