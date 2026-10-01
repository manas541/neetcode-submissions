class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                int num = board[i][j] - '1';

                if (rows[i][num] || cols[j][num] || boxes[getSubgridIndex(i, j)][num]) {
                    return false;
                }

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[getSubgridIndex(i, j)][num] = true;
            }
        }

        return true;
    }

    private int getSubgridIndex(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }
}
