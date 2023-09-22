package com.hz.arithmetic.lettcode.test75;

/**
 * 反转链表
 *
 * @author zhenghui
 * @since 2023/9/22
 */
public class Solution206 {

  public ListNode reverseList(ListNode head) {
    ListNode node = head, next = null, pre;
    while (node != null) {
      pre = node.next;
      node.next = next;
      next = node;
      node = pre;
    }
    return next;
  }

  private static class ListNode {

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
  }
}
