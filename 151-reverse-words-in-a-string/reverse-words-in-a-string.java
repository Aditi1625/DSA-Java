class Solution {
    public String reverseWords(String s) {
        
        String strs[] = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        
        
        for (int i = strs.length - 1; i >= 0; i--) {
            ans.append(strs[i]);
            
           
            if (i > 0) {
                ans.append(" ");
            }
        }
        
        return ans.toString();
    }
}