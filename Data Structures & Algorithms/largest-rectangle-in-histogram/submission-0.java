class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // 使用 Deque 代替 Stack
        // 每个元素是 int[]: [startIndex, height]
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i; // 当前柱子能向左延伸的最左边界

            // 栈顶高度大于当前柱子时，需要 pop 并计算面积
            while (!stack.isEmpty() && stack.peekLast()[1] > heights[i]) {
                int[] top = stack.removeLast(); // 弹出栈顶
                int index = top[0];
                int height = top[1];
                // 计算以被弹出的柱子为最矮柱子的矩形面积
                maxArea = Math.max(maxArea, height * (i - index));
                // 更新 start，使当前柱子继承被弹出柱子的左边界
                start = index;
            }

            // 当前柱子入栈，记录其可以向左延伸的最左位置
            stack.addLast(new int[]{start, heights[i]});
        }

        // 扫描完数组后，栈中可能还有元素
        // 这些柱子的右边界就是数组末尾
        int n = heights.length;
        while (!stack.isEmpty()) {
            int[] top = stack.removeLast();
            int index = top[0];
            int height = top[1];
            maxArea = Math.max(maxArea, height * (n - index));
        }

        return maxArea;
    }
}