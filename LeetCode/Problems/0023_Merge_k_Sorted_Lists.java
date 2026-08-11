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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode();
        ListNode point = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            point.next = curr;
            point = point.next;
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
}