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
    public int minMeetingRooms(List<Interval> intervals) {
        // Draw this out, we will see we basically need to find the number of concurrent meetings
        // Form two arrays for start and end time 
        // From there, check the number of overlapping
        
        // 1. Put the intervals into the start and end times
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        // 2. Sort the intervals
        for (Interval interval: intervals) {
            startTimes.add(interval.start);
            endTimes.add(interval.end);
        }
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        // 3. Maintain a counter for the number of concurrent time at any point in time
        int count = 0;
        int max = count;
        
        System.out.println(startTimes);
        System.out.println(endTimes);

        int endPointer = 0;
        int startPointer = 0;
        while (startPointer < startTimes.size()) {
            // If the current start is lesser than the first end, it means the meeting still ongoing
            if (startTimes.get(startPointer) < endTimes.get(endPointer)) {
                count ++; 
                startPointer ++;
            }
            
            // If the current start is later than the end, move the end up 
            else {
                count --;
                endPointer ++;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}
