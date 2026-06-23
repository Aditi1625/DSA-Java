class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Length = 2
        for (int j = 1; j <= m; j++) {
            up[j] = j - 1;
            down[j] = m - j;
        }

        if (n == 2) {
            long ans = 0;
            for (int j = 1; j <= m; j++) {
                ans = (ans + up[j] + down[j]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long[] prefDown = new long[m + 1];
            for (int j = 1; j <= m; j++) {
                prefDown[j] = (prefDown[j - 1] + down[j]) % MOD;
            }

            long[] suffUp = new long[m + 2];
            for (int j = m; j >= 1; j--) {
                suffUp[j] = (suffUp[j + 1] + up[j]) % MOD;
            }

            for (int j = 1; j <= m; j++) {
                newUp[j] = prefDown[j - 1];
                newDown[j] = suffUp[j + 1];
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int j = 1; j <= m; j++) {
            ans = (ans + up[j] + down[j]) % MOD;
        }

        return (int) ans;
    }
}