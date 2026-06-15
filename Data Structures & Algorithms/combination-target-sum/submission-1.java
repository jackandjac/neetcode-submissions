class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, 0, target, nums, new ArrayList<>(), results);
        return results;
    }
    private void backtrack(int start,  int acc, int target, int[] nums, List<Integer> path, List<List<Integer>> results) {
        if (acc == target) {
            results.add(new ArrayList<>(path));
        }

        for(int i = start; i < nums.length; i++) {
            if (nums[i] + acc <= target) {
                path.add(nums[i]);
                backtrack(i, acc + nums[i], target, nums, path, results);
                path.remove(path.size() -1);
            }
        }
    }
}
