import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();

        // Store all prefixes from arr1
        for (int num : arr1) {
            String s = String.valueOf(num);

            for (int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
        }

        int maxLen = 0;

        // Check prefixes from arr2
        for (int num : arr2) {
            String s = String.valueOf(num);

            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);

                if (set.contains(prefix)) {
                    maxLen = Math.max(maxLen, i);
                }
            }
        }

        return maxLen;
    }
}