package com.ethan.course.lettcode.huawei;

/**
 * @Author zhenghui
 * @Description 两数相加
 * @Date 2022/10/16
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode resultHead = new ListNode();
        ListNode p = resultHead;
        int bit = 0;
        while (first != null && second != null) {
            int val = (first.val + second.val + bit) % 10;
            bit = (first.val + second.val + bit) / 10;
            p.next = new ListNode(val);
            p = p.next;
            first = first.next;
            second = second.next;
        }
        while (first != null) {
            int val = (first.val + bit) % 10;
            bit = (first.val + bit) / 10;
            p.next = new ListNode(val);
            p = p.next;
            first = first.next;
        }
        while (second != null) {
            int val = (second.val + bit) % 10;
            bit = (second.val + bit) / 10;
            p.next = new ListNode(val);
            p = p.next;
            second = second.next;
        }
        if (bit > 0) {
            p.next = new ListNode(bit);
        }
        return resultHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = this.val;
            this.next = next;
        }
    }
}
