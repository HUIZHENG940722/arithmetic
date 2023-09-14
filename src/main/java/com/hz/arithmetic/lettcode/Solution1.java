package com.hz.arithmetic.lettcode;

import java.util.Arrays;

/**
 * 矩阵元素的边界值
 *
 * @author zhenghui
 * @since 2023/9/13
 */
public class Solution1 {

  /**
   * @param matrix int整型二维数组 矩阵
   * @return int整型
   */
  public int findTheMinWithColMaxs(int[][] matrix) {
    // write code here
    int n = matrix.length, m = matrix[0].length, result = Integer.MAX_VALUE;
    int[] maxVales = new int[m];
    Arrays.fill(maxVales, Integer.MIN_VALUE);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        maxVales[i] = Math.max(maxVales[i], matrix[j][i]);
      }
      result = Math.min(maxVales[i], result);
    }
    return result;
  }
}
