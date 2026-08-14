import java.util.*;

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

    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        while (slow != null) {
            st.push(slow);
            slow = slow.next;
        }
        ListNode point = head;
        ListNode tempHead = new ListNode();
        while (point != mid) {
            ListNode temp = point.next;
            tempHead.next = point;
            point.next = st.pop();
            tempHead = tempHead.next.next;
            point = temp;
        }
        if (!st.isEmpty()) {
            tempHead.next = st.pop();
            tempHead = tempHead.next;
        }
        tempHead.next = null;
    }
}