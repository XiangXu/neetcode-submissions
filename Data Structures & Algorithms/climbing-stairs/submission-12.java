class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return calculator(n, cache);
    }

    private int calculator(int n, int[] cache) {
        if(n <= 2) {
            return n;
        }

        if(cache[n] != 0) {
            return cache[n];
        }

        cache[n] = calculator(n - 1, cache) + calculator(n-2, cache);
        return cache[n];
    }
}
