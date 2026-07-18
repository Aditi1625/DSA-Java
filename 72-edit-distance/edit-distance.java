class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[j] stores the edit distance for the current character of word1 and first j characters of word2
        int[] dp = new int[n + 1];
        
        // Initialize base case: converting empty word1 to word2 requires j insertions
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }
        
        // Fill the DP array iteratively
        for (int i = 1; i <= m; i++) {
            int pre = dp[0]; // Stores the top-left diagonal value (dp[i-1][j-1])
            dp[0] = i;       // Base case: converting first i characters of word1 to empty word2
            
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Save the current value before overwriting it
                
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = pre; // Characters match, no new operation needed
                } else {
                    // Find the minimum of Replace (pre), Delete (dp[j]), and Insert (dp[j-1])
                    dp[j] = 1 + Math.min(pre, Math.min(dp[j], dp[j - 1]));
                }
                pre = temp; // Update pre for the next cell in the row
            }
        }
        
        return dp[n];
    }
}
