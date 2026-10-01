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

    // Sort meetings by start time
    intervals.sort((a, b) -> Integer.compare(a.start, b.start));

    // Check adjacent meetings
    for (int i = 1; i < intervals.size(); i++) {

        // Current meeting starts before previous meeting ends
        if (intervals.get(i).start < intervals.get(i - 1).end) {
            return false;
        }
    }

    return true;
}
}
