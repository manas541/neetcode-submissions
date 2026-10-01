class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

    int rows = heights.length;
    int cols = heights[0].length;

    boolean[][] pacific = new boolean[rows][cols];
    boolean[][] atlantic = new boolean[rows][cols];

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    // Pacific: top row
    for (int c = 0; c < cols; c++) {
        dfs(0, c, heights, pacific, directions);
    }

    // Pacific: left column
    for (int r = 0; r < rows; r++) {
        dfs(r, 0, heights, pacific, directions);
    }

    // Atlantic: bottom row
    for (int c = 0; c < cols; c++) {
        dfs(rows - 1, c, heights, atlantic, directions);
    }

    // Atlantic: right column
    for (int r = 0; r < rows; r++) {
        dfs(r, cols - 1, heights, atlantic, directions);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {

            if (pacific[r][c] && atlantic[r][c]) {

                result.add(Arrays.asList(r, c));
            }
        }
    }

    return result;
}
private void dfs(
    int r,
    int c,
    int[][] heights,
    boolean[][] ocean,
    int[][] directions
) {

    ocean[r][c] = true;

    for (int[] direction : directions) {

        int nr = r + direction[0];
        int nc = c + direction[1];

        // Outside grid
        if (nr < 0 || nr >= heights.length ||
            nc < 0 || nc >= heights[0].length) {
            continue;
        }

        // Already visited
        if (ocean[nr][nc]) {
            continue;
        }

        // Reverse flow condition
        if (heights[nr][nc] < heights[r][c]) {
            continue;
        }

        dfs(nr, nc, heights, ocean, directions);
    }
}
}