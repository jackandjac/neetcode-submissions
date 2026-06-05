class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[][] lrarray = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                lrarray[i][0] = nums[i];
            } else {
                lrarray[i][0] = nums[i] * lrarray[i -1][0];
            }
        }

        for (int i = n -1; i >=0; i--) {
            if (i == n -1) {
                lrarray[i][1] = nums[i];
            }else {
                lrarray[i][1] = nums[i] * lrarray[i + 1][1];
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = lrarray[i + 1][1];
            } else if (i == n -1) {
                res[i] = lrarray[i -1][0];
            } else {
                res[i] = lrarray[i-1][0] * lrarray[i +1][1];
            }
        }
        return res;
    }
}  
