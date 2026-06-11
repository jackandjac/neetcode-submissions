class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max(nums[i], nums[i] + curSum);
            max = Math.max(max, curSum);
        } 
        return max;
    }
}
