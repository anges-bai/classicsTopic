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
        public ListNode partition(ListNode pHead, int x) {
            // write code here
            if (pHead != null) {
                ListNode cur = pHead;
                ListNode flag = null;
                //因为链表中可能有多个满足条件的结点，故使用循环
                while (cur.next != null) {
                    if (cur == pHead && cur.val < x) {
                        flag = cur;
                    }
                    if (cur.next.val < x) {
                        if (flag != cur) {
                            ListNode tmp = cur.next;
                            cur.next = tmp.next;
                            if (flag == null) {
                                tmp.next = pHead;
                                pHead = tmp;
                            } else {
                                tmp.next = flag.next;
                                flag.next = tmp;
                            }
                            flag = tmp;
                        } else {
                            cur = cur.next;
                            flag = cur;
                        }
                    } else {
                        cur = cur.next;
                    }
                }
            }
            return pHead;

        }

       
    }
}

