class Solution {
public:
    bool isPalindrome(ListNode* head) {
        //额外空间复杂度O(n/2)
        
        /*使用两个指针，fast指针每次走两步，slow指针每次走一步；fast指针走到链表末尾的时候，
        slow指针走到链表的中间位置结点（链表长度n为偶数）或中间位置的前一个结点（链表长度n为奇数）
        */
        
        //判空
        if(head == NULL) return true;
        //单节点链表
        if(head->next == NULL) return true;
        
        ListNode* fast = head;
        ListNode* slow = head;//指向第一个结点
               
        //fast指针指向末尾结点，slow指针指向中间位置结点或中间位置的前一个结点
        
        ////注意：这里的结束判断主要看fast!!!
        while(fast->next != NULL && fast->next->next != NULL )
        {
            fast = fast->next->next;
            slow = slow->next;
        }
        //链表长度为偶数，fast指针最后多走一步到链表末尾
        if(fast->next)
            fast = fast->next;
        
        
         stack<int> s;
        //将链表后半部分元素压栈，通过栈来实现逆序
        while(slow->next)
        {
            s.push(slow->next->val);
            slow = slow->next;
        }
        
        //依次比较前半部分元素和逆序的后半部分元素
        while(!s.empty())
        {
            if(s.top() != head->val)
                return false;
            //前、后一起往后移动
            s.pop();
            head = head->next;
        }
        return true;
    }
};
