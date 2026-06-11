class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] cur = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]){
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                list.add(cur);
                cur = intervals[i];
            }
        }
        list.add(cur);
        return list.toArray(new int[0][]);
    }
}
