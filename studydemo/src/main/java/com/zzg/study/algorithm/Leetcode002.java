package com.zzg.study.algorithm;

/**
 * 两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Leetcode002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head=null;
        ListNode next=head;
        int carry=0;
        while(true){
            ListNode tmp=null;
            if(l1==null&&l2==null&&carry==0){
               break;
            }else if(l1!=null&&l2==null){

                if(l1.val+carry==10){
                    tmp=new ListNode(0);
                    carry=1;
                }else {
                    tmp=new ListNode(l1.val+carry);
                    carry=0;
                }
                l1=l1.next;
                if(head==null){
                    head=tmp;
                    next=head;
                }else {
                    next.next=tmp;
                    next=tmp;
                }

            }else if(l1==null&&l2!=null){
                if(l2.val+carry==10){
                    tmp=new ListNode(0);
                    carry=1;
                }else {
                    tmp=new ListNode(l2.val+carry);
                    carry=0;
                }
                l2=l2.next;
                if(head==null){
                    head=tmp;
                    next=head;
                }else {
                    next.next=tmp;
                    next=tmp;
                }
            }else {
                int sum=0;
                if(l1!=null&&l2!=null){
                    sum=l2.val+l1.val;
                    l1=l1.next;
                    l2=l2.next;
                }
                if(sum+carry>=10){
                    tmp=new ListNode(sum+carry-10);
                    carry=1;
                }else {
                    tmp=new ListNode(sum+carry);
                    carry=0;
                }
                if(head==null){
                    head=tmp;
                    next=head;
                }else {
                    next.next=tmp;
                    next=tmp;
                }
            }
        }
        return head;
    }

    /**
     * 别人的解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int addNum = 0;
        while(q!=null){
            if(p.next==null && q.next!=null)
                p.next = new ListNode(0);
            if(q.next==null && p.next!=null)
                q.next = new ListNode(0);
            int sumAll = addNum + p.val + q.val;
            p.val = sumAll % 10;
            addNum = sumAll / 10;
            if(p.next == null && q.next == null && addNum!=0)
                p.next = new ListNode(addNum);
            p = p.next;
            q = q.next;
        }
        return l1;
    }
}




class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
