class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (idxMap.containsKey(nums[i])) {
                return new int[]{idxMap.get(nums[i]), i};
            } else {
                idxMap.put(target - nums[i], i);
            }
        }

        return new int[]{};
    }
}
