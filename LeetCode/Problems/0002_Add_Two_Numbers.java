class Solution {
    int carry = 0;
    ListNode tempHead = new ListNode();

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            if (carry == 1) {
                ListNode lastNode = new ListNode(1, null);
                tempHead.next = lastNode;
            }
            return tempHead;
        }
        ListNode head = new ListNode();
        tempHead.next = tempHead = head;
        if (l1 != null && l2 != null) {
            head.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            addTwoNumbers(l1.next, l2.next);
        } else {
            if (l1 == null) {
                head.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                addTwoNumbers(l1, l2.next);
            } else {
                head.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                addTwoNumbers(l1.next, l2);
            }
        }
        return head;
    }
}