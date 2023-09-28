package com.hz.arithmetic.lettcode.test75;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 奇偶链表
 *
 * @author zhenghui
 * @since 2023/9/28
 */
public class Solution328 {

  public ListNode oddEvenList(ListNode head) {
    ListNode listNode1 = new ListNode(0), listNode2 = new ListNode(0), node = head,
        pre1 = listNode1, pre2 = listNode2;
    boolean flag = true;
    while (node != null) {
      if (flag) {
        flag = false;
        pre1.next = node;
        pre1 = node;
      } else {
        flag = true;
        pre2.next = node;
        pre2 = node;
      }
      node = node.next;
    }
    pre1.next = listNode2.next;
    pre2.next = null;
    return listNode1.next;
  }

  private static class ListNode {

    int val;
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
  }
}
