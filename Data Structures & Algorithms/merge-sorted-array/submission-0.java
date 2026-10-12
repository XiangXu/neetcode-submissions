class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1; // write position, starts at the end
        int i = m - 1; // largest remaining in nums1;
        int j = n - 1; // largets remaining in nums2;

        while(j >= 0) {
            if(i >=0 && nums1[i] >= nums2[j]) {
                nums1[last--] = nums1[i--];
            }
            else {
                nums1[last--] = nums2[j--];
            }
        }
    }
}