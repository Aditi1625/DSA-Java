class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;

        int[] freq = new int[size + 1];
        int a = 0, b = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        for (int i = 1; i <= size; i++) {
            if (freq[i] == 2) a = i;
            if (freq[i] == 0) b = i;
        }

        return new int[]{a, b};
    }
}
