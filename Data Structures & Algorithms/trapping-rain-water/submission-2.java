class Solution {
    public int trap(int[] height) {
        int water = 0;
        if(height.length < 2) {
            return water;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottom = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int width = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[bottom];
                water += width * currHeight;
            }
            stack.push(i);
        }
        return water;
    }
}
