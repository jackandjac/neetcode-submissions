class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                twoSum2(i, nums, results);
            }
        }
        return results;
    }
    private void twoSum2(int i, int[] nums, List<List<Integer>> results) {
        int l = i +1, r = nums.length -1;

        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];

            if (sum == 0) {
                results.add(List.of(nums[i], nums[l++], nums[r--]));
                while(l < r && nums[l-1] == nums[l]) {
                    l++;
                }
            } else if (sum > 0) {
                r--;
            } else {
                l++;
            }
        }
    }
}
