class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            // Even numbers cannot satisfy x | (x + 1) = num
            if ((num & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            int best = Integer.MAX_VALUE;

            // Try removing each set bit
            for (int b = 0; b < 31; b++) {
                if ((num & (1 << b)) != 0) {
                    int x = num ^ (1 << b);

                    if ((x | (x + 1)) == num) {
                        best = Math.min(best, x);
                    }
                }
            }

            ans[i] = (best == Integer.MAX_VALUE) ? -1 : best;
        }

        return ans;
    }
}