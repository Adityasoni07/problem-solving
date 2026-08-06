class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode point = head.next, temp = null;
        while (point != null) {
            if (point == head) {
                return true;
            } else {
                temp = point;
                point = point.next;
                temp.next = head;
            }
        }
        return false;
    }
}