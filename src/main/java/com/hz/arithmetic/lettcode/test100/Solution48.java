package com.hz.arithmetic.lettcode.test100;

/**
 * 旋转图像
 *
 * @author zhenghui
 * @since 2023/11/28
 */
public class Solution48 {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int[][] tmp = new int[n][n];
    for (int i = 0; i < n; i++) {
      System.arraycopy(matrix[i], 0, tmp[i], 0, n);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[j][n - 1 - i] = tmp[i][j];
      }
    }
  }
}
