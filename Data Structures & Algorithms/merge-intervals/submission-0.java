class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // Add the first interval
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] current = result.get(result.size() - 1);
            int[] next = intervals[i];

            // Overlap
            if (next[0] <= current[1]) {

                current[1] = Math.max(current[1], next[1]);

            } else {

                // No overlap
                result.add(next);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}