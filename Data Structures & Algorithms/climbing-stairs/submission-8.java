class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return calculation(n, cache);
    }

    private int calculation(int n, int[] cache) {
        if(n <= 1) {
            return 1;
        }

        if(cache[n] != 0) {
            return cache[n];
        }

        cache[n] = calculation(n - 1, cache) + calculation(n - 2, cache);

        return cache[n];
    }
}