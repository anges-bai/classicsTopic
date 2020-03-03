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

    public ListNode removeElements1(ListNode head, int val){
      if (head==null){
          return null;
      }
      head.next=removeElements1(head.next,val);
      return head.val==val?head.next:head;
    }

    
      return head;
    }
}
