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

    public ListNode mergeNodes(ListNode head) {
        ListNode t1 = head;
        ListNode t2 = head;

        if (head == null) {
            return null;
        }
        while (t2.next != null) {
            if (t2.next.val != 0) {
                head.val = head.val + t2.next.val;
                t2 = t2.next;
            } else if (t1.next.val == 0) {
                t1.next = t1.next.next;
            } else {
                t1.next = t2.next;
                t1 = t1.next;
                t1.val = head.val;
                head.val = 0;
                t2 = t2.next;
            }

        }
        head = head.next;

        return head;
    }
}