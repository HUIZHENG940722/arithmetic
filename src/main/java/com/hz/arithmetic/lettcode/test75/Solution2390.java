package com.hz.arithmetic.lettcode.test75;

import java.util.Optional;
import java.util.Stack;

/**
 * 从字符串中移除星号
 *
 * @author zhenghui
 * @since 2023/9/17
 */
public class Solution2390 {

  public String removeStars(String s) {
    Stack<Character> stack = new Stack<>();
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
      if (c == '*') {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(c);
      }
    }
    Optional<String> reduce = stack.stream().map(String::valueOf).reduce((x, y) -> x + y);
    return reduce.orElse("");
  }

  public String removeStars2(String s) {
    StringBuilder sb = new StringBuilder();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (c == '*') {
        if (sb.length() > 0) {
          sb.deleteCharAt(sb.length() - 1);
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
