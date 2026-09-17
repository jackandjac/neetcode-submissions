class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[1] - b[1]);

        int curEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++){
            if (curEnd > intervals[i][0]) {
                count++;
            } else {
                curEnd = intervals[i][1];
            }
        }
        return count;
    }
}

/*
1 2
  2 4 
1   4
*/
