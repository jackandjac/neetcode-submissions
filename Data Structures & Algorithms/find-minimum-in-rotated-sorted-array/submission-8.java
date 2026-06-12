class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int l = 0, r = n -1;

        if (nums[r] > nums[l]){
            return nums[l];
        }

        while(l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] > nums[mid +1]) {
                return nums[mid +1];
            } else if (nums[mid -1] > nums[mid]) {
                return nums[mid]; 
            } else if (nums[mid] > nums[l]) {
                l = mid +1;
            } else {
                r = mid -1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
