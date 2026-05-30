class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    
    private void backTracking(int index, int[] candidates, int target, 
                              List<Integer> tmpList, List<List<Integer>> result) {
        if(target <= 0) {
            if(target == 0) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            tmpList.add(candidates[i]);
            backTracking(i, candidates, target - candidates[i], tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
        
    }
}