class Solution {
    public String reverseWords(String s) {
        // Trim leading/trailing spaces and split by one or more spaces
        String strs[] = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        
        // Loop backwards through the words array
        for (int i = strs.length - 1; i >= 0; i--) {
            ans.append(strs[i]);
            
            // Add a space after the word, but not after the very last word
            if (i > 0) {
                ans.append(" ");
            }
        }
        
        return ans.toString();
    }
}
