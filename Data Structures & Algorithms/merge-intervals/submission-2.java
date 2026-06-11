class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> results = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)-> a[0] - b[0]);
        int[] cur = intervals[0];

        for (int i = 1; i < n; i++) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(intervals[i][1], cur[1]);
            }else {
                results.add(cur);
                cur = intervals[i];
            }
        } 
        results.add(cur);
        return results.toArray(new int[0][]);
    }
}
