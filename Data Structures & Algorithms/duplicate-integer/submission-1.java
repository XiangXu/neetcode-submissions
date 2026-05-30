class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int num : nums) {
            if(hashSet.contains(num)) {
                return true;
            }
            else {
                hashSet.add(num);
            }
        }

        return false;
    }
}
