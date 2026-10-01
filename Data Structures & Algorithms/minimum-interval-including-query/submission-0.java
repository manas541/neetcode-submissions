class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] result = new int[queries.length];

        int i = 0;

        for (int[] query : sortedQueries) {

            int q = query[0];

            while (i < intervals.length &&
                   intervals[i][0] <= q) {

                int left = intervals[i][0];
                int right = intervals[i][1];

                int size = right - left + 1;

                minHeap.offer(new int[]{size, right});

                i++;
            }

            while (!minHeap.isEmpty() &&
                   minHeap.peek()[1] < q) {

                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                result[query[1]] = -1;
            } else {
                result[query[1]] = minHeap.peek()[0];
            }
        }

        return result;
    }
}