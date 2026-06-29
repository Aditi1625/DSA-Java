class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Start at the top-right corner
        int row = 0;
        int col = n - 1;
        
        // Step through the matrix without going out of bounds
        while (row < m && col >= 0) {
            int current = matrix[row][col];
            
            if (current == target) {
                return true; 
            } else if (current > target) {
                col--; // Target is smaller, eliminate this column
            } else {
                row++; // Target is larger, eliminate this row
            }
        }
        
        return false; // Target not found
    }
}
