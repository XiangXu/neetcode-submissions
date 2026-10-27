class ListNode {
    ListNode prev;
    ListNode next;
    int val;

    public ListNode(int val) {
        this.prev = null;
        this.next = null;
        this.val = val;
    }
}

class MyLinkedList {

    private ListNode dummyHead;
    private ListNode dummyTail;

    public MyLinkedList() {
        this.dummyHead = new ListNode(0);
        this.dummyTail = new ListNode(0);
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }
    
    public int get(int index) {
        ListNode curr = dummyHead.next;
        while(curr != null && index > 0) {
            curr = curr.next;
            index --;
        }

        if(curr != null && curr != dummyTail && index == 0) {
            return curr.val;
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        ListNode curr = dummyHead.next;
        ListNode prev = dummyHead;
        prev.next = node;
        curr.prev = node;
        node.prev = prev;
        node.next = curr;
    }
    
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode curr = dummyTail.prev;
        ListNode next = dummyTail;
        node.prev = curr;
        curr.next = node;
        next.prev = node;
        node.next = next;
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
            prev.next = node;
            node.prev = prev;
            node.next = next;
            next.prev = node;
        }
    }
    
    public void deleteAtIndex(int index) {
        ListNode curr = dummyHead.next;
        while(curr != null && index > 0) {
            curr = curr.next;
            index --;
        }

        if(curr != null && curr != dummyTail && index == 0) {
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