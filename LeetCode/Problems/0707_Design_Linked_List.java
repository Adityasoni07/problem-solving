class MyLinkedList {
    int val;
    MyLinkedList next;
    MyLinkedList head, tail;

    public MyLinkedList() {
        this.next = null;
    }

    public int get(int index) {
        MyLinkedList temp = head;
        while (index >= 0 && temp != null) {
            if (index == 0) {
                return temp.val;
            }
            temp = temp.next;
            index--;
        }
        return -1;
    }

    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (head == null) {
            return;
        }
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        MyLinkedList temp = head;
        while (index > 0 && temp.next != null) {
            if (index == 1) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
            temp = temp.next;
            index--;
        }
        if (temp.next == null) {
            temp.next = newNode;
            tail = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        MyLinkedList temp = head;
        while (index > 0 && temp.next != null) {
            if (index == 1) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
            }
            temp = temp.next;
            index--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */