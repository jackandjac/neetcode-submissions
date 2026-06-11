/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
       intervals.sort( (a, b) -> a.start - b.start);
       if (intervals.size() <= 1) {
        return true;
       } 
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < cur.end) {
                return false;
            } else {
                cur = intervals.get(i);
            }
        }
        return true;
    }
}
