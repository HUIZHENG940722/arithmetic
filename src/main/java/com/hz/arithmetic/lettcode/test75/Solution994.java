package com.hz.arithmetic.lettcode.test75;

/**
 * 腐烂的橘子
 *
 * @author zhenghui
 * @since 2023/10/15
 */
public class Solution994 {

  public int orangesRotting(int[][] grid) {
    int m = grid.length, n = grid[0].length, result = 0;
    boolean exitFresh = false;
    while (true) {
      int goBadSum = 0;
      exitFresh = false;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 0) {
            continue;
          } else if (grid[i][j] == 1) {
            if (goBad(grid, i, j)) {
              grid[i][j] = 2;
              goBadSum++;
            } else {
              exitFresh = true;
            }
          } else {
            grid[i][j] += 1;
          }
        }
      }
      if (goBadSum > 0) {
        result++;
      } else {
        break;
      }
    }
    if (exitFresh) {
      return -1;
    }
    return result;
  }

  private boolean goBad(int[][] grid, int i, int j) {
    int m = grid.length, n = grid[0].length;
    if (j - 1 >= 0) {
      if (grid[i][j - 1] >= 3) {
        return true;
      }
    }
    if (i - 1 >= 0) {
      if (grid[i - 1][j] >= 3) {
        return true;
      }
    }
    if (j + 1 < n) {
      if (grid[i][j + 1] >= 2) {
        return true;
      }
    }
    if (i + 1 < m) {
      if (grid[i + 1][j] >= 2) {
        return true;
      }
    }
    return false;
  }
}
