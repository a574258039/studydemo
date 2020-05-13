package com.zzg.study.algorithm;

/**
 * 160. 相交链表
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        int countA = 0;
        while (a.next != null) {
            a = a.next;
            countA++;
        }

        ListNode b = headB;
        int countB = 0;
        while (b.next != null) {
            b = b.next;
            countB++;
        }
        if (countA > countB) {
            for (int i = 0; i < countA - countB; i++) {
                headA = headA.next;
            }
        }
        if (countA < countB) {
            for (int i = 0; i < countA - countB; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headA != headB) {
            headB = headB.next;
            headA = headA.next;
        }
        return headA == headB ? headA : null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
