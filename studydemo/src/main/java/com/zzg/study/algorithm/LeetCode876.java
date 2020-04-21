package com.zzg.study.algorithm;

/**
 * 876. 链表的中间结点
 */
public class LeetCode876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                fast = fast.next;
            }
        }
        return slow;
    }
}
