class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        prefix[0] = 1;
        postfix[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            postfix[nums.length - 1 - i] = nums[nums.length - i] * postfix[nums.length - i];
        }

        for(int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * postfix[i];
        }
        
        return result;
    }
}  
