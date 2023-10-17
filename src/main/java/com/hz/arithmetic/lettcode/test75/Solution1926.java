package com.hz.arithmetic.lettcode.test75;

/**
 * 迷宫中离入口最近的出口
 *
 * @author zhenghui
 * @since 2023/10/14
 */
public class Solution1926 {

  public int nearestExit(char[][] maze, int[] entrance) {
    int m = maze.length, n = maze[0].length, i = entrance[0], j = entrance[1];
    int[] result = new int[]{Integer.MAX_VALUE};
    nearestExit(maze, i, j, 0, result);
    return result[0] == Integer.MAX_VALUE ? -1 : result[0];
  }

  private void nearestExit(char[][] maze, int i, int j, int d, int[] result) {
    int m = maze.length, n = maze[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return;
    } else if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
      if (d != 0 && d < result[0]) {
        result[0] = d;
      }
    }
    if (i - 1 <= 0 && maze[i - 1][j] == '.') {
      maze[i - 1][j] = '0';
      nearestExit(maze, i - 1, j, d + 1, result);
    }
    if (j + 1 < n && maze[i][j + 1] == '.') {
      maze[i][j + 1] = '0';
      nearestExit(maze, i, j + 1, d + 1, result);
    }
    if (i + 1 < m && maze[i + 1][j] == '.') {
      maze[i + 1][j] = '0';
      nearestExit(maze, i + 1, j, d + 1, result);
    }
    if (j - 1 >= 0 && maze[i][j - 1] == '.') {
      maze[i][j - 1] = '0';
      nearestExit(maze, i, j - 1, d + 1, result);
    }
  }
}
