package com.hz.arithmetic.lettcode.test100;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 *
 * @author zhenghui
 * @since 2023/12/1
 */
public class Solution160 {

  /**
   * 哈希表法
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> visited = new HashSet<>();
    ListNode temp = headA;
    while (temp != null) {
      visited.add(temp);
      temp = temp.next;
    }
    temp = headB;
    while (temp != null) {
      if (visited.contains(temp)) {
        return temp;
      }
      temp = temp.next;
    }
    return null;
  }

  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;
  }

  private static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
