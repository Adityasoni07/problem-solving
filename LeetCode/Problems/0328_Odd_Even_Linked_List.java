class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode tempHead = head.next;
        ListNode t1 = head;
        ListNode t2 = head.next;
        while (t2 != null && t2.next != null) {
            t1.next = t1.next.next;
            t2.next = t2.next.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        t1.next = tempHead;
        return head;
    }
}