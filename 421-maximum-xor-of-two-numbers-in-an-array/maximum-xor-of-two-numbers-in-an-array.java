class Solution {
    // Define the Trie Node structure
    class TrieNode {
        // Index 0 for bit '0', index 1 for bit '1'
        TrieNode[] children = new TrieNode[2]; 
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        // Step 1: Insert all numbers into the Trie
        for (int num : nums) {
            TrieNode curr = root;
            // Process bits from MSB (30th bit) down to LSB (0th bit)
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new TrieNode();
                }
                curr = curr.children[bit]; // Moved to next node safely
            }
        }

        int maxXOR = 0;

        // Step 2: For each number, find the maximum possible XOR pair
        for (int num : nums) {
            TrieNode curr = root;
            int currentXOR = 0;

            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggledBit = 1 - bit; // The ideal opposite bit we want

                // If the opposite bit exists, go there to get a '1' in XOR
                if (curr.children[toggledBit] != null) {
                    currentXOR |= (1 << i); // Set the i-th bit to 1
                    curr = curr.children[toggledBit];
                } else {
                    // Otherwise, follow the same bit (resulting in a '0' in XOR)
                    curr = curr.children[bit];
                }
            }
            maxXOR = Math.max(maxXOR, currentXOR);
        }

        return maxXOR;
    }
}
