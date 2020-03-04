package com.bit.www;

/**
 * @Author: BaiMiao
 * @Date: 2020/3/4 11:27
 * @Description:
 */

 class ListNode3 {
    int val;
    ListNode next = null;

    ListNode3(int val) {
        this.val = val;
    }

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k){
        if (head==null || k<=0){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        for (int i=0;i<k-1;i++){
            if (fast.next!=null){
                fast=fast.next;
            }else{
                return null;
            }
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
}
