class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        result = []
        map = {}

        for i in range(len(nums)):
            value = target - nums[i]
            if value in map:
                result = [map[value], i];
                break;
            map[nums[i]] = i;

        return result;        