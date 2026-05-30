class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int key : map.keySet()) {
            int[] arr = new int[] {key, map.get(key)};
            queue.offer(arr);
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
