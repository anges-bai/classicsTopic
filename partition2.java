package com.bit.www;

/**
 * @Author: BaiMiao
 * @Date: 2020/3/4 12:06
 * @Description:
 */

 class ListNode4 {
    int val;
    ListNode next = null;

    ListNode4(int val) {
        this.val = val;
    }

    public class partition {
       

        public ListNode partition2(ListNode head, int x) {
            ListNode before_head = new ListNode(0); //小于 x 链表的头节点
            ListNode before = before_head; //跑小于 x 链表的引用
            ListNode after_head = new ListNode(0); //大于 x 链表的头节点
            ListNode after = after_head; //跑大于 x 链表的引用
            while (head != null) {
                if (head.val < x) {
                    // 如果结点 < x 则插到 before 链表中
                    before.next = head;
                    before = before.next;
                } else {
                    // 如果结点 >= x 则插到after链表中
                    after.next = head;
                    after = after.next;
                }
                // 跑原链表的引用
                head = head.next;
            }
            // Last node of "after" list would also be ending node of the reformed list
            after.next = null;
            //合并链表
            before.next = after_head.next;
            return before_head.next;
        }
    }
}

