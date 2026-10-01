class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        // We processed the entire word
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        // Normal character
        if (c != '.') {
            int idx = c - 'a';

            if (node.children[idx] == null) {
                return false;
            }

            return dfs(word, index + 1, node.children[idx]);
        }

        // Wildcard '.'
        for (TrieNode child : node.children) {

            if (child != null) {

                if (dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }

        return false;
    }
}