class Solution {
    public int numberOfSubstrings(String s) {
        // Track the last seen index of characters 'a', 'b', and 'c'
        int lastA = -1;
        int lastB = -1;
        int lastC = -1;
        
        int count = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            // Update the last seen position of the current character
            if (ch == 'a') {
                lastA = i;
            } else if (ch == 'b') {
                lastB = i;
            } else if (ch == 'c') {
                lastC = i;
            }
            
            // If we have seen all three characters at least once
            if (lastA != -1 && lastB != -1 && lastC != -1) {
                // Find the leftmost character that completes the trio
                int minIndex = Math.min(lastA, Math.min(lastB, lastC));
                
                // All substrings starting from index 0 up to minIndex are valid
                count += (minIndex + 1);
            }
        }
        
        return count;
    }
}
