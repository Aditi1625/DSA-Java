import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ranges;
        }
        
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {
                if (start == nums[i]) {
                    ranges.add(String.valueOf(start));
                } else {
                    ranges.add(start + "->" + nums[i]);
                }
                if (i < nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return ranges;
    }
}