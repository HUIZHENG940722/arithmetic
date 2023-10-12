package com.hz.arithmetic.lettcode.test75;

import java.util.PriorityQueue;

/**
 * 雇佣K位工人的总代价
 *
 * @author zhenghui
 * @since 2023/10/12
 */
public class Solution2462 {

  public static void main(String[] args) {
    int[] costs = new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
    long l = totalCost1(costs, 11, 2);
    System.out.println(l);
  }

  public static long totalCost1(int[] costs, int k, int candidates) {
    long result = 0;
    for (int i = 0; i < k; i++) {
      int minIndex = 0, min = Integer.MAX_VALUE;
      for (int j = 0; j < costs.length; j++) {
        if (costs[j] != -1 && costs[j] < min) {
          minIndex = j;
          min = costs[j];
        }
      }
      result += costs[minIndex];
      costs[minIndex] = -1;
    }
    return result;
  }

  public long totalCost(int[] costs, int k, int candidates) {
    long res = 0L;
    PriorityQueue<Integer> left = new PriorityQueue<>(), right = new PriorityQueue<>();
    int n = costs.length, i = 0, j = n - 1;
    // 初始化：将 [0, candidates] 范围内的元素加入 left 中，将 [n - candidate, n - 1] 范围内元素加入 right 中。
    while (i < candidates) {
      left.offer(costs[i++]);
    }
    while (j >= i && j >= n - candidates) {
      right.offer(costs[j--]);
    }
    while (k-- > 0) {
      // 由于队列可能为空，需要做判断，下面会比较大小然后取较小值，如果一个为空，直接赋值最大值。
      int a = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
      int b = right.isEmpty() ? Integer.MAX_VALUE : right.peek();
      if (a <= b) {
        res += a;
        left.poll();
        if (i <= j) {
          left.offer(costs[i++]);
        }
      } else {
        res += b;
        right.poll();
        if (i <= j) {
          right.offer(costs[j--]);
        }
      }
    }
    return res;
  }

}
