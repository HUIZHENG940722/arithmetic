package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表最大孪生和
 *
 * @author zhenghui
 * @since 2023/9/22
 */
public class Solution2130 {

  public int pairSum(ListNode head) {
    List<Integer> tmp = new ArrayList<>();
    ListNode node = head;
    while (node != null) {
      tmp.add(node.val);
      node = node.next;
    }
    int size = tmp.size(), result = Integer.MIN_VALUE;
    for (int i = 0; i <= (size / 2) - 1; i++) {
      result = Math.max(result, tmp.get(i) + tmp.get(size - i - 1));
    }
    return result;
  }

  class ListNode {

    private int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    public int getVal() {
      return val;
    }

    public void setVal(int val) {
      this.val = val;
    }

    public ListNode getNext() {
      return next;
    }

    public void setNext(ListNode next) {
      this.next = next;
    }
  }
}
