import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // cost[i][j] tracks the minimum health lost to reach cell (i, j)
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Double-ended queue storing coordinates as 1D arrays [row, col]
        Deque<int[]> dq = new ArrayDeque<>();
        
        // Initialize starting position
        cost[0][0] = grid.get(0).get(0);
        dq.addFirst(new int[]{0, 0});
        
        // Directions for Up, Down, Left, Right moves
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];
            
            // Short-circuit if we reached the destination
            if (r == m - 1 && c == n - 1) {
                break;
            }
            
            int currentCost = cost[r][c];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check boundaries
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextCost = currentCost + grid.get(nr).get(nc);
                    
                    // If a cheaper path to the neighboring cell is found
                    if (nextCost < cost[nr][nc]) {
                        cost[nr][nc] = nextCost;
                        
                        // 0-1 BFS placement optimization
                        if (grid.get(nr).get(nc) == 0) {
                            dq.addFirst(new int[]{nr, nc}); // Zero weight -> front
                        } else {
                            dq.addLast(new int[]{nr, nc});  // One weight -> back
                        }
                    }
                }
            }
        }
        
        // Check if the remaining health is 1 or more
        return health - cost[m - 1][n - 1] >= 1;
    }
}
