class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int answer = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                answer = Math.max(
                    answer,
                    dfs(matrix, row, col, dp)
                );
            }
        }

        return answer;
    }

    private int dfs(int[][] matrix,
                    int row,
                    int col,
                    int[][] dp) {

        // Already calculated
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int longest = 1;

        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Check boundaries
            if (newRow >= 0 && newRow < matrix.length
                    && newCol >= 0 && newCol < matrix[0].length

                    // Must be increasing
                    && matrix[newRow][newCol] > matrix[row][col]) {

                longest = Math.max(
                    longest,
                    1 + dfs(matrix, newRow, newCol, dp)
                );
            }
        }

        dp[row][col] = longest;

        return longest;
    }
}