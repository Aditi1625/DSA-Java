import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, int start) {
        
        result.add(new ArrayList<>(currentList));

        for (int i = start; i < nums.length; i++) {
            
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            currentList.add(nums[i]); 
            backtrack(result, currentList, nums, i + 1); 
            currentList.remove(currentList.size() - 1); 
        }
    }
}
