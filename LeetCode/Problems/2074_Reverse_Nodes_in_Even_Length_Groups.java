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
        int groupSize = 2;
        ListNode point = head.next;
        ListNode leftHead = head;
        while (point != null) {
            int size = 0;
            while (point != null && size < groupSize) {
                point = point.next;
                size++;
            }
            if (size % 2 == 0) {
                ListNode prev = point;
                ListNode first = leftHead.next;
                ListNode tempNext = first;
                while (first != point) {
                    ListNode next = first.next;
                    first.next = prev;
                    prev = first;
                    first = next;
                }
                leftHead.next = prev;
                leftHead = tempNext;
            } else {
                int j = size;
                while (j != 0) {
                    leftHead = leftHead.next;
                    j--;
                }
            }
            groupSize++;
        }
        return head;
    }
}