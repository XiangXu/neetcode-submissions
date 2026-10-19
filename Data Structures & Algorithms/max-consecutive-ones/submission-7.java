class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 1) {
                result = Math.max(result, right - left + 1);
            }
            else {
                left = right + 1;
            }
        }

        return result;
    }
}