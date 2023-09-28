package com.hz.arithmetic.lettcode.test75;

/**
 * 删除链表的中间节点
 *
 * @author zhenghui
 * @since 2023/9/28
 */
public class Solution2095 {

  public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode pre = new ListNode(0, head), fast = pre, slow = pre, can = pre;
    while (fast.next != null && fast.next.next != null) {
      can = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast.next != null) {
      slow.next = slow.next.next;
    } else {
      slow.next = slow.next.next;
    }
    return pre.next;
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
