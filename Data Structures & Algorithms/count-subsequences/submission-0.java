class Solution {
    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, t, 0, 0, dp);
    }

    private int solve(String s, String t,
                      int i, int j, int[][] dp) {

        // Formed all of t
        if (j == t.length()) {
            return 1;
        }

        // Not enough characters left in s
        if (i == s.length()) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {

            int take = solve(s, t, i + 1, j + 1, dp);

            int skip = solve(s, t, i + 1, j, dp);

            dp[i][j] = take + skip;

        } else {

            dp[i][j] = solve(s, t, i + 1, j, dp);
        }

        return dp[i][j];
    }
}