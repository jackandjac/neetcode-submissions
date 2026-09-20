class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = nums[i];
            } else {
                dp[i][0] = dp[i -1][0] * nums[i]; 
            }
        }
        for (int i = n -1; i >= 0; i--) {
            if (i == n -1) {
                dp[i][1] = nums[i];
            } else {
                dp[i][1] = dp[i +1][1] * nums[i];
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = dp[i+1][1];
            } else if (i == n -1) {
                res[i] = dp[i-1][0];
            }else {
                res[i] = dp[i-1][0] * dp[i +1][1];
            }
        }
        return res;
    }
}  
