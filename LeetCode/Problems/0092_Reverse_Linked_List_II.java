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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftNode = dummy;
        ListNode prev = null;
        ListNode curr = head;
        ListNode point = dummy;
        for (int i = 0; i <= right; i++) {
            if (i + 1 == left) {
                leftNode = point;
                curr = point.next;
            }
            if (i == right) {
                prev = point.next;
            }
            point = point.next;
        }
        ListNode second = prev;
        while (curr != second) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        leftNode.next = prev;
        return dummy.next;
    }
}