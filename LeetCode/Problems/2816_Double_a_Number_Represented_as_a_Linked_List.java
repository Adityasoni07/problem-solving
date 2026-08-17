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

    int carry = 0, sum;

    public ListNode doubleNumber(ListNode head) {
        if (head == null) {
            return head;
        }
        doubleNumber(head.next);
        sum = ((head.val * 2) % 10) + carry;
        carry = (head.val * 2) / 10;
        head.val = sum;
        return head;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode point = head;
        doubleNumber(head);
        if (carry == 1) {
            ListNode tempHead = new ListNode(1, head);
            tempHead.next = head;
            point = tempHead;
        }
        return point;
    }
}