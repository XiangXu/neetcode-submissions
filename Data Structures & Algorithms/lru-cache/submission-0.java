class LRUCache {
    
    private class CacheNode {
        int key;
        int value;
        
        CacheNode pre;
        CacheNode next;
        
        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Map<Integer, CacheNode> map;
    private int capacity;
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new CacheNode(0, 0);
        this.tail = new CacheNode(0, 0);
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }
    
    private void deleteNode(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void insertToHead(CacheNode node) {
        CacheNode headNext = head.next;
        head.next = node;
        headNext.pre = node;
        node.pre = head;
        node.next = headNext;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1; 
        }
        
        CacheNode node = map.get(key);
        deleteNode(node);
        insertToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size() == capacity) {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
            CacheNode currNode = new CacheNode(key, value);
            map.put(key, currNode);
            insertToHead(currNode);
        }
        else {
            CacheNode currNode = map.get(key);
            deleteNode(currNode);
            currNode.value = value;
            map.put(key, currNode);
            insertToHead(currNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */