package com.hz.arithmetic.lettcode.test100;

/**
 * 矩阵置零
 *
 * @author zhenghui
 * @since 2023/11/27
 */
public class Solution73 {

  public void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] tmp = new int[m][n];
    for (int i = 0; i < m; i++) {
      System.arraycopy(matrix[i], 0, tmp[i], 0, n);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (tmp[i][j] == 0) {
          for (int t = 0; t < n; t++) {
            matrix[i][t] = 0;
          }
          for (int k = 0; k < m; k++) {
            matrix[k][j] = 0;
          }
        }
      }
    }
  }
}
