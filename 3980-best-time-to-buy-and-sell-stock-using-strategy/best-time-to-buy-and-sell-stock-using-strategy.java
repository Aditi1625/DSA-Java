class Solution {

    public long maxProfit(int[] prices, int[] strategy, int k) {

        int n = prices.length;
        int half = k / 2;

        long originalProfit = 0;

        // Original profit
        for (int i = 0; i < n; i++) {
            originalProfit += 1L * strategy[i] * prices[i];
        }

        // Gain if changed to 0
        long[] makeZero = new long[n];

        // Gain if changed to 1
        long[] makeOne = new long[n];

        for (int i = 0; i < n; i++) {

            long oldValue = 1L * strategy[i] * prices[i];

            makeZero[i] = -oldValue;

            makeOne[i] = 1L * prices[i] - oldValue;
        }

        // First window
        long currentGain = 0;

        for (int i = 0; i < half; i++) {
            currentGain += makeZero[i];
        }

        for (int i = half; i < k; i++) {
            currentGain += makeOne[i];
        }

        long maxGain = Math.max(0, currentGain);

        // Sliding window
        for (int start = 1; start <= n - k; start++) {

            // Remove leaving elements
            currentGain -= makeZero[start - 1];
            currentGain -= makeOne[start + half - 1];

            // Add entering elements
            currentGain += makeZero[start + half - 1];
            currentGain += makeOne[start + k - 1];

            maxGain = Math.max(maxGain, currentGain);
        }

        // We can also choose not to modify
        return originalProfit + maxGain;
    }
}