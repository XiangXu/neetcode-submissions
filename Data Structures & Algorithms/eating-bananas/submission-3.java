class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Arrays.stream(piles).max().getAsInt();
        int eatRate = right;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int totalTime = 0;
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
