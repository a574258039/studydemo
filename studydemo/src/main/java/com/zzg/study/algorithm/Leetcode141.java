package com.zzg.study.algorithm;

public class Leetcode141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

//        ListNode tortoise = head;
//        ListNode hare = head;
//        while (hare != null && hare.next != null) {
//            tortoise = tortoise.next;
//            hare = hare.next.next;
//            if (tortoise == hare) {
//                return true;
//            }
//        }
//        return false;
    }

    public static void main(String[] args) {

        ListNode node=new ListNode(1);
        ListNode node2=new ListNode(2);
        node.next=node2;


        boolean result=new Leetcode141().hasCycle(node);
        System.out.printf(""+result);


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
