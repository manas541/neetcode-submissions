class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        // 1. Put all words into Trie
        for (String word : words) {
            insert(word);
        }

        List<String> result = new ArrayList<>();

        // 2. Start DFS from every cell
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(
        char[][] board,
        int row,
        int col,
        TrieNode node,
        List<String> result
    ) {

        // Outside board
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        // Already visited
        if (board[row][col] == '#') {
            return;
        }

        char c = board[row][col];
        int index = c - 'a';

        // Current path is not a prefix of any word
        if (node.children[index] == null) {
            return;
        }

        node = node.children[index];

        // Found a complete word
        if (node.word != null) {
            result.add(node.word);

            // Prevent duplicate answer
            node.word = null;
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Explore 4 directions
        dfs(board, row + 1, col, node, result); // down
        dfs(board, row - 1, col, node, result); // up
        dfs(board, row, col + 1, node, result); // right
        dfs(board, row, col - 1, node, result); // left

        // Backtrack: restore original character
        board[row][col] = c;
    }
}
