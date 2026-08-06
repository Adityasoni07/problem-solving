/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
       ListNode second=head;
       int count=0;
       
       if(head.next==null||head==null)
       {
         return head;
       }
       while(second!=null)   
        { 
          if(count%2!=0)
          {
            head=head.next;
          }
          second=second.next;
          count++;
        } 
   
        return head;

    }
}