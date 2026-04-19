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
        // 1. Sort the intervals 
        // 2. Iterate through
        // - As long as the second index is less then the first index, means it is ok
        intervals.sort((a,b) -> a.start - b.start);
        for (int i = 0; i < intervals.size() - 1; i ++) {
            Interval currInterval = intervals.get(i);
            Interval nextInterval = intervals.get(i + 1);
            if (currInterval.end > nextInterval.start){
                return false;
            }
        }
        return true;
    }
}
