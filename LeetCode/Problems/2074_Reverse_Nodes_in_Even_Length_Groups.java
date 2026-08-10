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

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode tempHead = head;
        int size = 0;
        while (tempHead != null) {
            size++;
            tempHead = tempHead.next;
        }
        ListNode leftNode = head;
        int i = 2;
        size--;
        while (size > 0) {
            if ((i <= size && i % 2 == 1) || (size <= i && size % 2 == 1)) {
                int j = i;
                while (leftNode != null && j > 0) {
                    leftNode = leftNode.next;
                    j--;
                }
                size -= i;
            } else {
                int j = 1;
                ListNode temp = leftNode;
                while (temp.next != null && j <= i) {
                    j++;
                    temp = temp.next;
                }
                ListNode prev = temp.next;
                ListNode curr = leftNode.next;
                ListNode tempNext = leftNode.next;
                ListNode second = prev;
                while (curr != second) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                leftNode.next = prev;
                leftNode = tempNext;
                size -= i;
            }
            i++;
        }
        return head;
    }
}