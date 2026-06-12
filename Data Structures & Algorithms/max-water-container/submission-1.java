class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int l = 0, r = n -1;
        int max = 0;
        while (l < r){
            max = Math.max(max, (r - l) * Math.min(heights[l], heights[r]));
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
