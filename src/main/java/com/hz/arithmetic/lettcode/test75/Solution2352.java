package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 相等行列对
 *
 * @author zhenghui
 * @since 2023/9/26
 */
public class Solution2352 {

  public static void main(String[] args) {
    int[][] grid = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
    int i = equalPairs(grid);
    System.out.println(i);
  }

  public static int equalPairs(int[][] grid) {
    Map<List<Integer>, Integer> map = new HashMap<>();
    int m = grid.length, n = grid[0].length;
    for (int[] ints : grid) {
      List<Integer> tmp = new ArrayList<>();
      for (int anInt : ints) {
        tmp.add(anInt);
      }
      map.put(tmp, map.getOrDefault(tmp, 0) + 1);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      List<Integer> tmp = new ArrayList<>();
      for (int j = 0; j < m; j++) {
        tmp.add(grid[j][i]);
      }
      if (map.containsKey(tmp)) {
        result += map.get(tmp);
      }
    }
    return result;
  }
}
