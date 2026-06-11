import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(1);
        visited[1] = true;

        int depth = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int next : graph[node]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        if (depth == 0)
            return 0;

        return (int) power(2, depth - 1);
    }

    private long power(long base, long exp) {
        long ans = 1;

        while (exp > 0) {
            if ((exp & 1) == 1)
                ans = (ans * base) % MOD;

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return ans;
    }
}