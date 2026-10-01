class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initially, assume every amount is impossible
        Arrays.fill(dp, amount + 1);

        // 0 coins are needed to make amount 0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (i - coin >= 0) {
                    dp[i] = Math.min(
                        dp[i],
                        dp[i - coin] + 1
                    );
                }
            }
        }

        // If still impossible, return -1
        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }
}