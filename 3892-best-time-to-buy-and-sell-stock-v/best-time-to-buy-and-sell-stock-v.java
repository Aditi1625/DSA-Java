class Solution {
    public long maximumProfit(int[] prices, int k) {

        int n = prices.length;

        // dp[t][0] = no active transaction
        // dp[t][1] = holding bought stock
        // dp[t][2] = holding short-sold stock

        long[][] dp = new long[k + 1][3];

        for (int t = 0; t <= k; t++) {
            dp[t][1] = Long.MIN_VALUE;
            dp[t][2] = Long.MIN_VALUE;
        }

        for (int price : prices) {

            long[][] next = new long[k + 1][3];

            for (int t = 0; t <= k; t++) {
                next[t][0] = dp[t][0];
                next[t][1] = dp[t][1];
                next[t][2] = dp[t][2];
            }

            for (int t = 0; t <= k; t++) {

                // Start normal transaction (buy)
                next[t][1] = Math.max(next[t][1],
                                      dp[t][0] - price);

                // Start short selling transaction
                next[t][2] = Math.max(next[t][2],
                                      dp[t][0] + price);

                // Close normal transaction
                if (t < k && dp[t][1] != Long.MIN_VALUE) {
                    next[t + 1][0] = Math.max(
                        next[t + 1][0],
                        dp[t][1] + price
                    );
                }

                // Close short transaction
                if (t < k && dp[t][2] != Long.MIN_VALUE) {
                    next[t + 1][0] = Math.max(
                        next[t + 1][0],
                        dp[t][2] - price
                    );
                }
            }

            dp = next;
        }

        long ans = 0;

        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[t][0]);
        }

        return ans;
    }
}
