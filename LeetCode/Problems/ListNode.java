
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

class Solution {
    ListNode t2 = null;
    boolean ans = true;

    public void testPalindrome(ListNode t1) {
        if (t2 == null) {
            t2 = t1;
            return;
        }
        if (t2.next == null) {
            t2 = t1.next;
            return;
        }
        t2 = t2.next.next;
        testPalindrome(t1.next);
        if (ans == false) {
            return;
        }
        if (t1.val != t2.val) {
            ans = false;
        }
        t2 = t2.next;
        return;
    }

    public boolean isPalindrome(ListNode head) {
        t2 = head;
        testPalindrome(head);
        return ans;
    }
}