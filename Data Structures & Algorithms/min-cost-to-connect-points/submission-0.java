class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        int[] minDist = new int[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n];

        minDist[0] = 0;

        int totalCost = 0;

        for (int i = 0; i < n; i++) {

            // Find the unvisited point
            // with the smallest connection cost
            int current = -1;

            for (int j = 0; j < n; j++) {

                if (!visited[j] &&
                    (current == -1 || minDist[j] < minDist[current])) {

                    current = j;
                }
            }

            // Add this point to MST
            visited[current] = true;
            totalCost += minDist[current];

            // Update distances to remaining points
            for (int j = 0; j < n; j++) {

                if (!visited[j]) {

                    int distance =
                        Math.abs(points[current][0] - points[j][0])
                        + Math.abs(points[current][1] - points[j][1]);

                    minDist[j] =
                        Math.min(minDist[j], distance);
                }
            }
        }

        return totalCost;
    }
}