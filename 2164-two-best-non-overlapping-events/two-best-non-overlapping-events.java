import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;

        // suffix max values
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int currentValue = events[i][2];

            // binary search for next non-overlapping event
            int left = i + 1;
            int right = n - 1;
            int nextIndex = -1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                // next event must start AFTER current end
                if (events[mid][0] > events[i][1]) {
                    nextIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int total = currentValue;

            if (nextIndex != -1) {
                total += suffixMax[nextIndex];
            }

            ans = Math.max(ans, total);
        }

        return ans;
    }
}