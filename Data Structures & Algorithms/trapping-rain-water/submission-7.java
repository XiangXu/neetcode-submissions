class Solution {
    public int trap(int[] height) {
        if(height.length <= 2) {
            return 0;
        }

        int heightestIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[heightestIndex]) {
                heightestIndex = i;
            }
        }

        int result = 0;

        int highestLeft = 0;
        for(int i = 0; i < heightestIndex; i++) {
            if(height[i] > highestLeft) {
                highestLeft = height[i];
            }
            else {
                result += highestLeft - height[i];
            }
        }

        int highestRight = 0;
        for(int i = height.length - 1; i > heightestIndex; i--) {
            if(height[i] > highestRight) {
                highestRight = height[i];
            }
            else {
                result += highestRight - height[i];
            }
        }
        return result;
    }
}
