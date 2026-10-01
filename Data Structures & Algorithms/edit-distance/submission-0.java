class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Convert first i characters of word1
        // into empty string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Convert empty string
        // into first j characters of word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // Characters match
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    // Delete
                    int delete = dp[i - 1][j];

                    // Insert
                    int insert = dp[i][j - 1];

                    // Replace
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(
                        delete,
                        Math.min(insert, replace)
                    );
                }
            }
        }

        return dp[m][n];
    }
}