class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[][] dp = new int[n][2];

        for(int i = 0; i < n-1; i++) {
            if (i == 0) {
                dp[i][0] = nums[i];
            } else if (i == 1) {
                dp[i][0] = Math.max(dp[i-1][0], nums[i]);
            } else {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0] + nums[i]);
            }
        }
        for (int i = 1; i < n; i++) {
            if (i ==1) {
                dp[i][1] = nums[i];
            } else if (i == 2) {
                dp[i][1] = Math.max(dp[i-1][1], nums[i]);
            } else {
                dp[i][1] = Math.max(dp[i-1][1], nums[i] + dp[i-2][1]);
            }
        }
        return Math.max(dp[n-1][1], dp[n-2][0]);
    }
}
