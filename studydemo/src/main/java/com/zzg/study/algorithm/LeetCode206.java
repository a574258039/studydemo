package com.zzg.study.algorithm;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 翻转链表
 */
public class LeetCode206 {


    public static void main(String[] args) {

        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        node1.next=node2;
        ListNode node3=new ListNode(3);
        node2.next=node3;
        ListNode node4=new ListNode(4);
        node3.next=node4;
        ListNode node5=new ListNode(5);
        node4.next=node5;

        ListNode re=LeetCode206.reverseList(node1);
        System.out.printf(""+re);


        LocalDateTime l=LocalDateTime.now().minusDays(1);

        System.out.printf(""+l);


        BigDecimal profit=new BigDecimal(-0.0000001);
        double deliveryLoss=-0.1;


       int i= profit.compareTo(new BigDecimal(-0.001));

        System.out.printf("11");
    }



    public static  ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

//    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode reverseHead = head;
//        while (head.next != null) {
//            ListNode node = head.next;
//            head.next = node.next;
//            node.next = reverseHead;
//            reverseHead = node;
//        }
//        return reverseHead;
//    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
