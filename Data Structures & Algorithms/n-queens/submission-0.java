class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> positiveDiags = new HashSet<>();
        Set<Integer> negativeDiags = new HashSet<>();

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(
            0,
            n,
            board,
            result,
            cols,
            positiveDiags,
            negativeDiags
        );

        return result;
    }

    private void backtrack(
        int row,
        int n,
        char[][] board,
        List<List<String>> result,
        Set<Integer> cols,
        Set<Integer> positiveDiags,
        Set<Integer> negativeDiags) {

        // All queens placed
        if (row == n) {

            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);

            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {

            // Check if position is unsafe
            if (cols.contains(col) ||
                positiveDiags.contains(row + col) ||
                negativeDiags.contains(row - col)) {

                continue;
            }

            // CHOOSE
            board[row][col] = 'Q';

            cols.add(col);
            positiveDiags.add(row + col);
            negativeDiags.add(row - col);

            // EXPLORE
            backtrack(
                row + 1,
                n,
                board,
                result,
                cols,
                positiveDiags,
                negativeDiags
            );

            // UNDO
            board[row][col] = '.';

            cols.remove(col);
            positiveDiags.remove(row + col);
            negativeDiags.remove(row - col);
        }
    }
}