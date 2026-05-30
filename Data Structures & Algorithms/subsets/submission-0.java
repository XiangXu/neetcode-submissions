class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void backTracking(List<List<Integer>> result, List<Integer> tmpList, int start, int[] nums) {
        result.add(new ArrayList<>(tmpList));
        for(int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backTracking(result, tmpList, i + 1, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
