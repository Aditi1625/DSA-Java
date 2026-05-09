import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {

            // If list is empty OR no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } 
            else {
                // Overlapping intervals → merge
                merged.get(merged.size() - 1)[1] =
                    Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}