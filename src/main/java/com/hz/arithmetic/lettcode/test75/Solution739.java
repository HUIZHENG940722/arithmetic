package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 每日温度
 *
 * @author zhenghui
 * @since 2023/9/20
 */
public class Solution739 {

  /**
   * 错误的逻辑
   *
   * @param temperatures
   * @return
   */
  public int[] dailyTemperatures1(int[] temperatures) {
    // 表示的是第i索引以后的最大值的索引位置
    int[] result = new int[temperatures.length];
    int i = temperatures.length - 2, index = temperatures.length - 1, max = temperatures[index];
    for (; i >= 0; i--) {
      if (max <= temperatures[i]) {
        index = i;
        max = temperatures[i];
        result[i] = 0;
      } else {
        result[i] = index - i;
      }
    }
    return result;
  }

  /**
   * 超出时间复杂度
   *
   * @param temperatures
   * @return
   */
  public int[] dailyTemperatures2(int[] temperatures) {
    int len = temperatures.length;
    int[] result = new int[len];
    for (int i = 0; i < len; i++) {
      int j = i + 1;
      while (j < len && temperatures[j] <= temperatures[i]) {
        j++;
      }
      if (j < len) {
        result[i] = j - i;
      } else {
        result[i] = 0;
      }
    }
    return result;
  }

  /**
   * 单调栈
   *
   * @param temperatures
   * @return
   */
  public int[] dailyTemperatures(int[] temperatures) {
    Deque<int[]> queue = new ArrayDeque<>();
    int len = temperatures.length;
    int[] result = new int[len];
    for (int i = 0; i < len; i++) {
      int temperature = temperatures[i];
      while (!queue.isEmpty() && temperature > queue.peek()[1]) {
        int[] pop = queue.pop();
        result[pop[0]] = i - pop[0];
      }
      queue.push(new int[]{i, temperature});
    }
    return result;
  }
}
