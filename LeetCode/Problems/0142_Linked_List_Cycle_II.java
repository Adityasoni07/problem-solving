import java.util.Hashtable;

class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        Hashtable<ListNode, Integer> H1 = new Hashtable<>();
        while (head != null) {
            if (H1.containsKey(head)) {
                return head;
            } else {
                H1.put(head, head.val);
            }
            head = head.next;
        }
        return null;
    }
}