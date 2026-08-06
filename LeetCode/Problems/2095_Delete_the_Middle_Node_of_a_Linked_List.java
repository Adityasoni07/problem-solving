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

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode tp = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tp = slow;
            slow = slow.next;
        }
        tp.next = tp.next.next;
        return head;
    }
}