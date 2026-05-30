class Solution {
    public int climbStairs(int n) {
        // Memoization array to store results for each step
        int[] memo = new int[n + 1];
        
        // Start the recursive function with memoization
        return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo) {
        // Base cases
        if (n <= 1) return 1;

        // Check if result for step n is already computed
        if (memo[n] != 0) return memo[n];

        // Calculate and store result in memo array
        memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);

        return memo[n];
    }
}