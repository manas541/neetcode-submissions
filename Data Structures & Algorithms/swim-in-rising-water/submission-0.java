class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        // [time, row, col]
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int time = current[0];
            int row = current[1];
            int col = current[2];

            // Already processed
            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            // Reached destination
            if (row == n - 1 && col == n - 1) {
                return time;
            }

            // Explore neighbors
            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= n ||
                    newCol < 0 || newCol >= n ||
                    visited[newRow][newCol]) {
                    continue;
                }

                int newTime =
                    Math.max(time, grid[newRow][newCol]);

                pq.offer(new int[]{
                    newTime,
                    newRow,
                    newCol
                });
            }
        }

        return -1;
    }
}