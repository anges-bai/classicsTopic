/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

static const auto __ = []() {
    // turn off sync
    std::ios::sync_with_stdio(false);
     // untie in/out streams
    std::cin.tie(nullptr);
    return nullptr;
}();


class Solution {
public:
    bool isPalindrome(ListNode* head) {
        //额外空间复杂度O(1)
        
               
        //判空
        if(head == NULL) return true;
        //单节点链表
        if(head->next == NULL) return true;
        //双节点链表
        if(head->next->next == NULL)
            if(head->val == head->next->val)
                return true;
            else
                return false;
        
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
        
        
        //-----区别在这里，元素不压栈，直接将链表后半部分元素逆序，比较完后得出结果后，再还原链表，返回结果--------//
        
        //---------------链表的后半部分元素“倒序”-------------------//
        ListNode* p = slow->next;
        ListNode* q = NULL;
        ListNode* cur = NULL;
        
        slow->next = NULL;
        while(p)
        {   
            cur = p->next;
            p->next = q;
            q = p;
            p = cur;
        }
        
        
       //依次比较 前半部分元素 和 逆序的后半部分元素
        while(1) 
        {
            if(fast->val != head->val)
            {
                //链表复原
                ListNode* m = q->next;
                ListNode* n = NULL;
                ListNode* cur2 = NULL;
                q->next = NULL;
                while(m){
                    cur2 = m->next;
                    m->next = n;
                    n = m;
                    m = cur2;
                }
                slow->next = n;
   
                return false;
            }
               
            //前、后一起往后移动
            fast = fast->next;
            head = head->next;
            
            //--------在这里判断结束，是调试的结果----//
            //针对这种情况：（3）——>(1)——>(2)——>(3),后半部分反转之后的链表是（3）——>(1)——>(3)——>(2)  
            // 如果使用while(head->next)作为结束，会少比较一次，也就是最后（1）和（2）不会比较到，从而出错
            if(fast == NULL)
                break;
        }
        
         //链表复原
        ListNode* m = q->next;
        ListNode* n = NULL;
        ListNode* cur2 = NULL;
        q->next = NULL;
        while(m){
            cur2 = m->next;
            m->next = n;
            n = m;
            m = cur2;
         }
        slow->next = n;
   
        return true;
    }
};
