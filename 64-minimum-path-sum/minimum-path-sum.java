class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp array to store the minimum path sum for the current row
        int[] dp = new int[n];
        
        // Initialize the first cell
        dp[0] = grid[0][0];
        
        // Initialize the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Fill the DP table for the remaining rows
        for (int i = 1; i < m; i++) {
            // Update the first element of the row (can only come from above)
            dp[0] += grid[i][0];
            
            for (int j = 1; j < n; j++) {
                // The minimum path to current cell is the value of the cell 
                // plus the minimum of coming from above (dp[j]) or left (dp[j-1])
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        
        // The last element contains the minimum path sum to the bottom-right corner
        return dp[n - 1];
    }
}
