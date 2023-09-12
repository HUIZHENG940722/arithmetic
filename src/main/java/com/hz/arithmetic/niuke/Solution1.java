package com.hz.arithmetic.niuke;

import java.util.ArrayList;

/**
 * 提取数字
 *
 * @author zhenghui
 * @since 2023/9/10
 */
public class Solution1 {

  public ArrayList<Integer> extraNum(String s) {
    // write code here
    int len = s.length(), i = 0;
    ArrayList<Integer> result = new ArrayList<>();
    while (i < len) {
      int j = i;
      while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        i++;
      }
      if (j < i) {
        result.add(Integer.parseInt(s.substring(j, i)));
      }
      i++;
    }
    return result;
  }
}
