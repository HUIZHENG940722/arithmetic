package com.hz.arithmetic.lettcode.test75;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhenghui
 * @since 2023
 */
class RecentCounter {

  List<Integer> times;
  int size;

  public RecentCounter() {
    times = new LinkedList<>();
    size = 0;
  }

  public int ping(int t) {
    times.add(t);
    size++;
    while (times.get(0) < t - 3000) {
      times.remove(0);
      size--;
    }
    return size;
  }
}