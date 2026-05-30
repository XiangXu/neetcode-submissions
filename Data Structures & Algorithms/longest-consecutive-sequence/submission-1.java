class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int result = 1;
        for(int num : set) {
            // Check if current number is the start point
            if(!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                // Count consecutive numbers
                while(set.contains(current + 1)) {
                    current ++;
                    count++;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
