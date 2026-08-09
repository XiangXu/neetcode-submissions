class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class MyLinkedList {

    private ListNode head;
    private int size;

    public MyLinkedList() {
        this.head = new ListNode(0);
        this.size = 0;
    }
    
    public int get(int index) {
       if(index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head.next;
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) {
            return;
        }

        if(index == 0) {
            ListNode newHead = new ListNode(val);
            newHead.next = head.next;
            head.next = newHead;
        }
        else {
            ListNode curr = head;
            for(int i = 0; i < index; i++) {
                curr = curr.next;
            }
            ListNode temp = new ListNode(val);
            temp.next = curr.next;
            curr.next = temp;
        }

        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        if(index == 0) {
            head.next = head.next.next;
        }
        else {
            ListNode curr = head;
            for(int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size --;
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