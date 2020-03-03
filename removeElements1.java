import java.util.List;

/**
 * @Author: BaiMiao
 * @Date: 2020/3/3 17:08
 * @Description:
 */

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
  }

public class deleteVal {

   

    public ListNode removeElements(ListNode head,int val){

      while (head.next!=null&&head.val==val){
          head=head.next;
      }
      if (head==null){
          return null;
      }
      ListNode pre=head;
      while (pre.next!=null){
          if (pre.next.val==val){
              pre.next=pre.next.next;
          }else{
              pre=pre.next;
          }
      }
      return head;
    }
}
