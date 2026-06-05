class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, 0, target, nums, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int s, int acc, int target, int[] nums, List<Integer> path, List<List<Integer>> results){
        if (acc == target) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = s; i < nums.length; i++) {
            if (acc + nums[i] <= target) {
                path.add(nums[i]);
                backtrack(i, acc + nums[i], target, nums, path, results);
                path.remove(path.size() -1);
            }
        }
    }
}
