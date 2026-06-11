class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[1] - b[1]);
        int curEnd = Integer.MIN_VALUE;
        int remove = 0;

        for (int[] interval: intervals) {
            if (interval[0]< curEnd) {
                remove++;
            } else{
                curEnd = interval[1];
            }
        }
        return remove;
    }
}
