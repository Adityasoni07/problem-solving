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

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode d1 = dummy1;
        ListNode d2 = dummy2;
        ListNode point = head;
        while (point != null) {
            if (point.val < x) {
                d1.next = point;
                d1 = point;
            } else {
                d2.next = point;
                d2 = point;
            }
            point = point.next;
        }
        if (dummy1.next == null) {
            return dummy2.next;
        }
        d1.next = dummy2.next;
        d2.next = null;
        return dummy1.next;
    }
}