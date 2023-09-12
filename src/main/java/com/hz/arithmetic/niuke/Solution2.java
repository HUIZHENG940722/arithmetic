package com.hz.arithmetic.niuke;

/**
 * @author zhenghui
 * @since 2023/9/10
 */
public class Solution2 {

  public static void main(String[] args) {
    System.out.println('M' - 'A');
  }

  /**
   * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
   *
   * @param s string字符串
   * @return int整型
   */
  public int turnTimes(String s) {
    if (s.length() != 3) {
      return -1;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      char c = s.charAt(i);
      int val = c - 'A';
      if (val <= 9) {
        sb.append(val);
      } else {
        char c1 = (char) (val - 10 + 'A');
        sb.append(c1);
      }
    }
    int i = Integer.parseInt(sb.toString(), 26);
    return Integer.parseInt("2C1", 26) - i;
  }
}
