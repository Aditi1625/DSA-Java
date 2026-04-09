class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            // update max
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // reset if negative
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}