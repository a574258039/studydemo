package com.zzg.study.algorithm;

/**
 * 142. 环形链表 II
 * 找到环形链表的入口
 */
public class Leetcode142 {


    public static void main(String[] args) {


        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;


        ListNode result = new Leetcode142().detectCycle(node1);
        System.out.printf(""+result);


    }

    /**
     * 判断入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode node = getCycleNode(head);
        if (node == null) {
            return null;
        }
        while (node != head) {
            node = node.next;
            head = head.next;
        }
        return node;
    }

    /**
     * 找相遇点
     * @param head
     * @return
     */
    public ListNode getCycleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //return slow.next;
        return slow;
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
