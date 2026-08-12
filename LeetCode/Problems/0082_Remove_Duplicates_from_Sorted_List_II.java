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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode point = head;
        while (point != null) {
            if (point.next != null && point.val == point.next.val) {
                while (point.next != null && point.val == point.next.val) {
                    point = point.next;
                }
                prev.next = point.next;
                point = point.next;
            } else {
                prev = point;
                point = point.next;
            }
        }

        return dummy.next;
    }
}