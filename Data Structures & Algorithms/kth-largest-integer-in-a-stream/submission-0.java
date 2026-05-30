class KthLargest {

    private Queue<Integer> priorityQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>();
        for(int num : nums) {
            priorityQueue.offer(num);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
    }
    
    public int add(int val) {
        priorityQueue.offer(val);
        if(priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
