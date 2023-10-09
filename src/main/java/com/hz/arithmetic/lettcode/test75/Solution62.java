package com.hz.arithmetic.lettcode.test75;

/**
 * 不同路径
 *
 * @author zhenghui
 * @since 2023/10/9
 */
public class Solution62 {

  /**
   * 递归
   *
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths1(int m, int n) {
    if (m <= 0 || n <= 0) {
      return 0;
    } else if (m == 1 || n == 1) {
      return 1;
    }
    return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
  }

  public int uniquePaths(int m, int n) {
    int[][] flag = new int[m][n];
    for (int i = 0; i < n; i++) {
      flag[0][i] = 1;
    }
    for (int i = 0; i < m; i++) {
      flag[i][0] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        flag[i][j] = flag[i - 1][j] + flag[i][j - 1];
      }
    }
    return flag[m - 1][n - 1];
  }
}
