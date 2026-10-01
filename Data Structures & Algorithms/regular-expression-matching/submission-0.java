class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        Boolean[][] dp = new Boolean[m + 1][n + 1];

        return solve(s, p, 0, 0, dp);
    }

    private boolean solve(
        String s,
        String p,
        int i,
        int j,
        Boolean[][] dp
    ) {

        // Pattern is finished
        if (j == p.length()) {
            return i == s.length();
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Check current character
        boolean firstMatch =
            i < s.length() &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean answer;

        // Next character is *
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Option 1: skip x*
            boolean skip =
                solve(s, p, i, j + 2, dp);

            // Option 2: use x*
            boolean use =
                firstMatch &&
                solve(s, p, i + 1, j, dp);

            answer = skip || use;

        } else {

            // Normal character or '.'
            answer =
                firstMatch &&
                solve(s, p, i + 1, j + 1, dp);
        }

        dp[i][j] = answer;

        return answer;
    }
}