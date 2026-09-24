class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return helper(n, cache);
    }

    private int helper(int n, int[] cache) {
        if(n <= 2) {
            return n;
        }

        if(cache[n] != 0) {
            return cache[n];
        } 

        cache[n] = helper(n - 2, cache) + helper(n - 1, cache);
        return cache[n];
    }
}
