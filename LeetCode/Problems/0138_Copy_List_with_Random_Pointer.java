import java.util.*;

class Solution {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        int i = 1;
        Node temp = head;
        while (temp != null) {
            map.put(temp, i);
            temp = temp.next;
            i++;
        }
        map.put(null, i);
        HashMap<Integer, Node> newMap = new HashMap<>();
        Node dummy = new Node(0);
        Node prev = dummy;
        temp = head;
        i = 1;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newMap.put(i, newNode);
            newNode.random = temp.random;
            prev.next = newNode;
            prev = prev.next;
            temp = temp.next;
            i++;
        }
        prev.next = null;
        newMap.put(i, null);
        temp = dummy.next;
        while (temp != null) {
            int random = map.get(temp.random);
            temp.random = newMap.get(random);
            temp = temp.next;
        }
        return dummy.next;
    }
}