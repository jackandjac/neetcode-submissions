class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n -1;
        if ( n == 1) {
            return nums[0];
        }

        if ( nums[l] < nums[r]) {
            return nums[l];
        }

        while ( l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] > nums[mid +1]) {
                return nums[mid +1];
            } else if (nums[mid -1] > nums[mid]) {
                return nums[mid];
            } else if ( nums[l] < nums[mid]) {
                l = mid +1;
            } else {
                r = mid -1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
