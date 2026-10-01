class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int day = n - 1; day >= 0; day--) {
            
            dp[day][0] = Math.max(
                dp[day + 1][0],
                -prices[day] + dp[day + 1][1]
            );

            dp[day][1] = Math.max(
                dp[day + 1][1],
                prices[day] + dp[day + 2][0]
            );
        }

        return dp[0][0];
    }
}