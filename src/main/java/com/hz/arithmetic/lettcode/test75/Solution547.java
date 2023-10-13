package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 省份数量
 *
 * @author zhenghui
 * @since 2023/10/13
 */
public class Solution547 {

  public int findCircleNum(int[][] isConnected) {
    int sum = isConnected.length, result = 0;
    int[] flag = new int[sum];
    for (int i = 0; i < sum; i++) {
      if (flag[i] == 1) {
        continue;
      }
      result++;
      Queue<Integer> queue = new ArrayDeque<>();
      flag[i] = 1;
      queue.offer(i);
      while (!queue.isEmpty()) {
        Integer poll = queue.poll();
        for (int t = 0; t < sum; t++) {
          if (isConnected[poll][t] == 1 && flag[t] == 0) {
            queue.offer(t);
            flag[t] = 1;
          }
        }
      }
    }
    return result;
  }
}
