package com.bit.www;

/**
 * @Author: BaiMiao
 * @Date: 2020/3/3 19:26
 * @Description:
 */

class ListNode2 {
    int val;
    ListNode next;
    ListNode2(int x) {
        val = x;
    }
}

public class middleNode {
    public ListNode middleNode(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=head.next.next;
            slow=head.next;
        }
        return slow;
    }
}
