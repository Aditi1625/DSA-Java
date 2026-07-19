public class Solution {
    public int numDecodings(String s) {
        // An empty string or a string starting with '0' cannot be decoded
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        
        // Base cases:
        // singleStep represents dp[i-1] (initially for string of length 1)
        int singleStep = 1; 
        // doubleStep represents dp[i-2] (initially for string of length 0)
        int doubleStep = 1; 

        for (int i = 1; i < n; i++) {
            int current = 0;
            
            // 1. Check if the single digit s.charAt(i) is valid (1-9)
            if (s.charAt(i) != '0') {
                current += singleStep;
            }

            // 2. Check if the two-digit combination s.substring(i-1, i+1) is valid (10-26)
            int twoDigits = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigits >= 10 && twoDigits <= 26) {
                current += doubleStep;
            }

            // If it can't be decoded as a single or double digit, string is invalid
            if (current == 0) {
                return 0;
            }

            // Move the state forward for the next iteration
            doubleStep = singleStep;
            singleStep = current;
        }

        return singleStep;
    }
}
