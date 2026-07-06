class Solution {
    public int mySqrt(int x) {
        // Base cases for 0 and 1
        if (x < 2) {
            return x;
        }
        
        int left = 1;
        int right = x / 2; // The square root of x (where x >= 2) is always <= x / 2
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Use division (mid <= x / mid) instead of (mid * mid <= x) 
            // to safely prevent integer overflow
            if (mid <= x / mid) {
                ans = mid;      // mid could be the answer, save it
                left = mid + 1; // Try to find a larger value
            } else {
                right = mid - 1; // mid is too large, search the lower half
            }
        }
        
        return ans;
    }
}
