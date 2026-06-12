class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[][] products = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                products[i][0] = nums[i];
            } else {
                products[i][0] = products[i-1][0] * nums[i];
            }
        }

        for (int i = n -1; i >= 0; i--) {
            if (i == n -1) {
                products[i][1] = nums[i];
            } else {
                products[i][1] = products[i+1][1] * nums[i];
            }
        }
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = products[i +1][1];
            } else if (i == n -1) {
                res[i] = products[n -2][0];
            } else {
                res[i] = products[i-1][0] * products[i+1][1];
            }
        }
        return res;
    }
}  
