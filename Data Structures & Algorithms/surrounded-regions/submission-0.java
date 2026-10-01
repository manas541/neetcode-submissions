class Solution {
    public void solve(char[][] board) {

    int rows = board.length;
    int cols = board[0].length;

    // Visit O's on top and bottom borders
    for (int c = 0; c < cols; c++) {

        if (board[0][c] == 'O') {
            dfs(board, 0, c);
        }

        if (board[rows - 1][c] == 'O') {
            dfs(board, rows - 1, c);
        }
    }

    // Visit O's on left and right borders
    for (int r = 0; r < rows; r++) {

        if (board[r][0] == 'O') {
            dfs(board, r, 0);
        }

        if (board[r][cols - 1] == 'O') {
            dfs(board, r, cols - 1);
        }
    }

    // Convert surrounded O's to X
    // Convert safe T's back to O
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {

            if (board[r][c] == 'O') {
                board[r][c] = 'X';
            }
            else if (board[r][c] == 'T') {
                board[r][c] = 'O';
            }
        }
    }
}
    private void dfs(char[][] board, int r, int c) {

    // Outside the board
    if (r < 0 || r >= board.length ||
        c < 0 || c >= board[0].length) {
        return;
    }

    // Only process O
    if (board[r][c] != 'O') {
        return;
    }

    // Mark as safe
    board[r][c] = 'T';

    // Down
    dfs(board, r + 1, c);

    // Up
    dfs(board, r - 1, c);

    // Right
    dfs(board, r, c + 1);

    // Left
    dfs(board, r, c - 1);
}
}
