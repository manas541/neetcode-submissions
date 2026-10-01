class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        // Sort meetings by start time
        intervals.sort((a, b) ->
            Integer.compare(a.start, b.start)
        );

        // Min Heap stores ending times of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval meeting : intervals) {

            // If the earliest room is free, reuse it
            if (!minHeap.isEmpty() &&
                minHeap.peek() <= meeting.start) {

                minHeap.poll();
            }

            // Add the current meeting's ending time
            minHeap.offer(meeting.end);
        }

        return minHeap.size();
    }
}