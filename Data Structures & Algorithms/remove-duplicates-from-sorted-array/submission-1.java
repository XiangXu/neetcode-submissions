class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for(int right = 1; right < nums.length; right++) {
            if(nums[left] != nums[right]) {
                left = left + 1;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }
}