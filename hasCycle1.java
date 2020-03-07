
  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        //创建集合对象
        HashSet<ListNode> set = new HashSet<ListNode>();
        //遍历链表
        ListNode p = head;
        while (p != null){
           if (set.contains(p)){
               return true;
           }else{
               set.add(p);
           }
           p = p.next;
        }
        return false;
    }
}
