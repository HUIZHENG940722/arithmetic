package com.hz.arithmetic.lettcode.test75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 独一无二的出现次数
 *
 * @author zhenghui
 * @since 2023/9/14
 */
public class Solution1207 {

  public boolean uniqueOccurrences(int[] arr) {
    Set<Integer> set = new HashSet<>();
    Arrays.sort(arr);
    int len = arr.length, sum = 0;
    for (int i = 0; i < len; i++) {
      int left = i;
      while (i + 1 < len && arr[i] == arr[i + 1]) {
        i++;
      }
      set.add(i - left + 1);
      sum++;
    }
    return set.size() == sum;
  }
}
