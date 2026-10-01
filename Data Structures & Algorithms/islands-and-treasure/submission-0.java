class Solution {
    public void islandsAndTreasure(int[][] rooms) {

    int rows = rooms.length;
    int cols = rooms[0].length;

    Queue<int[]> queue = new LinkedList<>();

    // Put all gates into the queue
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {

            if (rooms[r][c] == 0) {
                queue.offer(new int[]{r, c});
            }
        }
    }

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    // Multi-source BFS
    while (!queue.isEmpty()) {

        int[] current = queue.poll();

        int r = current[0];
        int c = current[1];

        for (int[] direction : directions) {

            int nr = r + direction[0];
            int nc = c + direction[1];

            // Check boundaries
            if (nr < 0 || nr >= rows ||
                nc < 0 || nc >= cols) {
                continue;
            }

            // Only process empty rooms
            if (rooms[nr][nc] == Integer.MAX_VALUE) {

                rooms[nr][nc] = rooms[r][c] + 1;

                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
    }
