import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Include element
            current.add(nums[i]);

            // Recurse
            backtrack(i + 1, nums, current, result);

            // Backtrack (remove last element)
            current.remove(current.size() - 1);
        }
    }
}