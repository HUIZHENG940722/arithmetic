package com.hz.arithmetic.lettcode.test75;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 无限集中最小数字
 *
 * @author zhenghui
 * @since 2023/10/11
 */
public class SmallestInfiniteSet {

  PriorityQueue<Integer> queue;

  public SmallestInfiniteSet() {
    queue = new PriorityQueue<>();
  }

  public int popSmallest() {
    if (!queue.isEmpty()) {
      return queue.poll();
    }
    return Integer.MIN_VALUE;
  }

  public void addBack(int num) {
    if (!queue.contains(num)) {
      queue.offer(num);
    }
  }
}
