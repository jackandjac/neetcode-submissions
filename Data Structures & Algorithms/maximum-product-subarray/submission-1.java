class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = nums[i];
                dp[i][1] = nums[i];
            } else {
                dp[i][0] = Math.max(nums[i], Math.max(nums[i] * dp[i-1][0], nums[i] * dp[i-1][1]));
                dp[i][1] = Math.min(nums[i] , Math.min(nums[i] * dp[i-1][0], nums[i] * dp[i-1][1]));
            }
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
