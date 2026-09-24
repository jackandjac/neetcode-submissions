class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1] ) {
                twoSum2(nums, i, results);
            }
        }
        return results;
    }

    private void twoSum2(int[] nums, int i, List<List<Integer>> results ) {
        int l = i + 1, r = nums.length -1;
        while (l < r) {
         int sum = nums[i] + nums[l] + nums[r];
         if (sum == 0) {
            results.add(List.of(nums[i], nums[l++], nums[r--]));
            while (l < r && nums[l] == nums[l -1]) {
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
