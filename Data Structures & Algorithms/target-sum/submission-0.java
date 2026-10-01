class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        // Find maximum possible absolute sum
        for (int num : nums) {
            total += num;
        }

        // Target is impossible
        if (Math.abs(target) > total) {
            return 0;
        }

        int offset = total;

        int[][] dp = new int[nums.length + 1][2 * total + 1];

        // At the beginning:
        // index = 0
        // sum = 0
        dp[0][offset] = 1;

        for (int i = 0; i < nums.length; i++) {

            for (int sum = -total; sum <= total; sum++) {

                int ways = dp[i][sum + offset];

                if (ways == 0) {
                    continue;
                }

                // Choose +
                dp[i + 1][sum + nums[i] + offset] += ways;

                // Choose -
                dp[i + 1][sum - nums[i] + offset] += ways;
            }
        }

        return dp[nums.length][target + offset];
    }
}