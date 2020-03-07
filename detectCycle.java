/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
         if (head == null || head.next == null)
            return null;
        //先判断链表是否有环
        ListNode p = head.next, q = head;
        while (p != q) {
            if (p == null || p.next == null)
                return null;
            else {
                p = p.next.next;
                q = q.next;
            }
        }
        //从这个循环出来，说明链表是一个有环的链表
        //求出这个环中链表的个数
        //默认个数是1，因为p从q的next开始跑的
        //这里加一个虚拟的指针比较好理解
        int k = 1;
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        for (p = q.next; p != q; p = p.next, k++) ;
        for (p = tempHead; k != 0; p = p.next, k--) ;
        for (q = tempHead; q != p; p = p.next, q = q.next) ;
        return p;

    }
}
