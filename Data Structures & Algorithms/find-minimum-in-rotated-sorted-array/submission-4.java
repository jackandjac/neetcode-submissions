class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length -1;
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[l] < nums[r]) {
            return nums[l];
        }

        while (l <= r) {
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
        return -1;
    }
}
