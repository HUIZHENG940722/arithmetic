package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 迷宫中离入口最近的出口
 *
 * @author zhenghui
 * @since 2023/10/14
 */
public class Solution1926 {

  public static void main(String[] args) {
    char[][] maze = new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
    int[] entrance = new int[]{1, 2};
    nearestExit(maze, entrance);
  }

  public static int nearestExit(char[][] maze, int[] entrance) {
    Queue<int[]> queue = new ArrayDeque<>();
    int m = maze.length, n = maze[0].length;
    int[][] tmp = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    queue.offer(new int[]{entrance[0], entrance[1], 0});
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      if ((poll[0] == 0 || poll[0] == m - 1 || poll[1] == 0 || poll[1] == n - 1) && poll[2] > 0) {
        return poll[2];
      } else {
        for (int[] ints : tmp) {
          int x = poll[0] + ints[0], y = poll[1] + ints[1], t = poll[2] + 1;
          if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.') {
            queue.offer(new int[]{x, y, t});
          }
        }
      }
    }
    return -1;
  }
}
