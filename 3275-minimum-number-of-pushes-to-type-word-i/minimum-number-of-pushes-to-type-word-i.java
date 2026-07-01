class Solution {
    public int minimumPushes(String word) {
        int length = word.length();
        int totalPushes = 0;
        
        // Group 1: Up to 8 letters need 1 push
        if (length > 0) {
            totalPushes += Math.min(length, 8) * 1;
        }
        // Group 2: Next 8 letters need 2 pushes
        if (length > 8) {
            totalPushes += Math.min(length - 8, 8) * 2;
        }
        // Group 3: Next 8 letters need 3 pushes
        if (length > 16) {
            totalPushes += Math.min(length - 16, 8) * 3;
        }
        // Group 4: Remaining letters need 4 pushes
        if (length > 24) {
            totalPushes += (length - 24) * 4;
        }
        
        return totalPushes;
    }
}
