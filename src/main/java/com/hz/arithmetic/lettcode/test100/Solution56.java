package com.hz.arithmetic.lettcode.test100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author zhenghui
 * @since 2023/11/23
 */
public class Solution56 {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    List<int[]> merged = new ArrayList<>();
    int len = intervals.length;
    for (int[] interval : intervals) {
      int l = interval[0], r = interval[1];
      if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < l) {
        merged.add(new int[]{l, r});
      } else {
        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}
