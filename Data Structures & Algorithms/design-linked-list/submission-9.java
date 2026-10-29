class ListNode {
    ListNode prev;
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class MyLinkedList {
    private ListNode dummyHead;
    private ListNode dummyTail;

    public MyLinkedList() {
        this.dummyHead = new ListNode(0);
        this.dummyTail = new ListNode(0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int index) {
        ListNode curr = dummyHead.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if (curr != null && curr != dummyTail && index == 0) {
            return curr.val;
        }

        return -1;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        ListNode next = dummyHead.next;
        dummyHead.next = newHead;
        newHead.prev = dummyHead;
        newHead.next = next;
        next.prev = newHead;
    }

    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        ListNode prev = dummyTail.prev;
        prev.next = newTail;
        newTail.prev = prev;
        newTail.next = dummyTail;
        dummyTail.prev = newTail;
    }

    public void addAtIndex(int index, int val) {
        ListNode curr = dummyHead.next;
        while(curr != null && index > 0) {
            curr = curr.next;
            index --;
        }

        if(curr != null && index == 0) {
            ListNode node = new ListNode(val);
            ListNode next = curr;
            ListNode prev = curr.prev;
            node.prev = prev;
            node.next = next;
            prev.next = node;
            next.prev = node;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode curr = dummyHead.next;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if (curr != null && curr != dummyTail && index == 0) {
            ListNode next = curr.next;
            ListNode prev = curr.prev;
            next.prev = prev;
            prev.next = next;
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