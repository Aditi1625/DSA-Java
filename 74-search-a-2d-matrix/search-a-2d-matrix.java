class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Define search boundaries for the virtual 1D array
        int low = 0;
        int high = (m * n) - 1;
        
        while (low <= high) {
            // Prevents potential integer overflow compared to (low + high) / 2
            int mid = low + (high - low) / 2; 
            
            // Map 1D index back to 2D coordinates
            int row = mid / n;
            int col = mid % n;
            
            int midElement = matrix[row][col];
            
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
