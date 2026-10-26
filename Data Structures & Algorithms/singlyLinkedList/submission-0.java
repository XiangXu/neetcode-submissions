class ListNode {
    ListNode next;
    int val;

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}  

class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1); // set default val to -1
        this.tail = this.head;
    }

    public int get(int index) {
        ListNode curr = head.next;
        int i = 0;
        while(curr != null) {
            if(i == index) {
                return curr.val;
            }
            i++;
            curr = curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head.next = newHead;
        if(newHead.next == null) {
            tail = newHead;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        tail = tail.next;
    }

    public boolean remove(int index) {
        ListNode curr = head;
        int i = 0;

        while(i < index && curr != null) {
            curr = curr.next;
            i++;
        }

        if(curr != null && curr.next != null) {
            if(curr.next == tail) {
                tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }

        return false;

    } 

    public ArrayList<Integer> getValues() {
       ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = this.head.next;
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}
