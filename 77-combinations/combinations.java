import java.util.*;

class Solution {
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(1, n, k, new ArrayList<>(), result);
        
        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // If combination size becomes k
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all possible numbers
        for (int i = start; i <= n; i++) {
            current.add(i);                 // choose
            backtrack(i + 1, n, k, current, result); // explore
            current.remove(current.size() - 1); // unchoose
        }
    }
}