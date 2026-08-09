class MyLinkedList {
    
    class ListNode {
        int val;
        ListNode next;
        
        public ListNode(int val) {
            this.val = val;
        }
    }
    
    private int size;
    private ListNode head;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {       
        if(index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
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
            ListNode prev = head;
            head = new ListNode(val);
            head.next = prev;
            
        }
        else {
            ListNode curr = head;
            for(int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            ListNode tmp = new ListNode(val);
            tmp.next = curr.next;
            curr.next = tmp;   
        }
        
        size++;
       
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        
        size --;
        
        if(index == 0) {
            head = head.next;
            return;
        }
        
        ListNode curr = head;
        for(int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        
        curr.next = curr.next.next;
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