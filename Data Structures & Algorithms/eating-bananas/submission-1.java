class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 0;
        int right = piles[piles.length - 1];
        int eatRate = right;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            long totalTime = 0;
            for(int pile : piles) {
                totalTime += Math.ceil((double)pile / mid);
            }
            if(totalTime <= h) {
                eatRate = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return eatRate;
    }
}
