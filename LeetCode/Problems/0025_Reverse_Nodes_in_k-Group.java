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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode leftNode = dummy;
        ListNode point = dummy;

        while (point != null) {

            int j = 0;
            while (point != null && j < k) {
                j++;
                point = point.next;
            }

            if (point == null) {
                break;
            }

            ListNode tempNext = point.next;

            ListNode prev = tempNext;
            ListNode curr = leftNode.next;

            while (curr != tempNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode oldFirst = leftNode.next;
            leftNode.next = prev;
            leftNode = oldFirst;
            point = leftNode;
        }

        return dummy.next;
    }
}