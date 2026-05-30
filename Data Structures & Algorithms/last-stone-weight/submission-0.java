class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for(int stone : stones) {
            priorityQueue.offer(stone);
        }

        while(priorityQueue.size() > 1) {
            int firstStone = priorityQueue.poll();
            int secondStone = priorityQueue.poll();
            int diffStone = firstStone - secondStone;
            System.out.println(firstStone + " - " + secondStone + " = " + diffStone);
            if(diffStone != 0) {
                priorityQueue.offer(diffStone);
            }
        }

        return priorityQueue.size() == 0 ? 0 : priorityQueue.poll();
    }
}
