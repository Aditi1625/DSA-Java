import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Start from second last row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i + 1).get(j);
                int diagonal = triangle.get(i + 1).get(j + 1);

                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(down, diagonal));
            }
        }

        return triangle.get(0).get(0);
    }
}