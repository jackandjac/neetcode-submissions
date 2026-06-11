class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int s = newInterval[0], e = newInterval[1];
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int i = 0;

        while (i < n && intervals[i][1] < s) {
            list.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= e) {
            s = Math.min(s, intervals[i][0]);
            e = Math.max(e, intervals[i][1]);
            i++;
        }
        list.add(new int[]{s ,e});
        while(i < n) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[0][]);
    }
}
