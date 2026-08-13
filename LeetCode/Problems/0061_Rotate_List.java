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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = head;
        int len = 1;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode point = head;
        for (int i = 1; i < len - k; i++) {
            point = point.next;
        }
        last.next = head;
        head = point.next;
        point.next = null;
        return head;
    }
}