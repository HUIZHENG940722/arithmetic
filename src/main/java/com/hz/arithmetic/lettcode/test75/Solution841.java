package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 钥匙和房间
 *
 * @author zhenghui
 * @since 2023/10/12
 */
public class Solution841 {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int len = rooms.size();
    int[] flag = new int[len];
    Queue<Integer> queue = new ArrayDeque<>();
    flag[0] = 1;
    List<Integer> list = rooms.get(0);
    for (Integer i : list) {
      queue.offer(i);
    }
    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      if (flag[poll] == 0) {
        List<Integer> list1 = rooms.get(poll);
        for (Integer i : list1) {
          queue.offer(i);
        }
        flag[poll] = 1;
      }
    }
    for (int i : flag) {
      if (i == 0) {
        return false;
      }
    }
    return true;
  }
}
