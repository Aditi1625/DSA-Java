public class Solution {
    // Renamed to match LeetCode's exact expected method name
    public int countMajoritySubarrays(int[] nums, int target) {
        int totalSubarrays = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int balance = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    balance++;
                } else {
                    balance--;
                }

                if (balance > 0) {
                    totalSubarrays++;
                }
            }
        }
        return totalSubarrays;
    }
}
