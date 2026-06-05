class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        // First increasing part
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        // p cannot be 0
        if (i == 0) return false;

        int p = i;

        // Decreasing part
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }

        // Must have at least one decreasing step
        if (i == p) return false;

        int q = i;

        // Final increasing part
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        // Must have at least one increasing step after q
        if (i == q) return false;

        // Must reach the end
        return i == n - 1;
    }
}