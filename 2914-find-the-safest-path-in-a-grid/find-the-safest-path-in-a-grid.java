import java.util.*;

public class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // If the start or destination contains a thief, the safeness factor is 0
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        
        // Step 1: Multi-source BFS to calculate min distance to any thief
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == Integer.MAX_VALUE) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        // Step 2: Modified Dijkstra's Algorithm using a Max-Heap
        // Each element in maxHeap is an array: {safeness_factor, r, c}
        // Ordered in descending order of safeness_factor
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        boolean[][] visited = new boolean[n][n];
        
        maxHeap.offer(new int[]{dist[0][0], 0, 0});
        visited[0][0] = true;
        
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int safeness = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            // If we reached the destination, return the maximized safeness factor
            if (r == n - 1 && c == n - 1) {
                return safeness;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // The safeness of the path to the neighbor is limited by the current path's safeness or the neighbor's cell value
                    int nextSafeness = Math.min(safeness, dist[nr][nc]);
                    maxHeap.offer(new int[]{nextSafeness, nr, nc});
                }
            }
        }
        
        return 0;
    }
}
