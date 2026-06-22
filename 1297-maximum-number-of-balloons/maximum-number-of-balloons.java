class Solution {
    public int maxNumberOfBalloons(String text) {
        // Step 1: Count frequencies of all lowercase letters
        int[] counts = new int[26];
        for (char c : text.toCharArray()) {
            counts[c - 'a']++;
        }

        // Step 2: Extract counts for the characters in "balloon"
        int bCount = counts['b' - 'a'];
        int aCount = counts['a' - 'a'];
        int lCount = counts['l' - 'a'] / 2; // Needs 2 'l's per word
        int oCount = counts['o' - 'a'] / 2; // Needs 2 'o's per word
        int nCount = counts['n' - 'a'];

        // Step 3: Find the limiting character
        int minBalloons = bCount;
        minBalloons = Math.min(minBalloons, aCount);
        minBalloons = Math.min(minBalloons, lCount);
        minBalloons = Math.min(minBalloons, oCount);
        minBalloons = Math.min(minBalloons, nCount);

        return minBalloons;
    }
}
