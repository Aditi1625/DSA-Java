class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int ALPHABET = 26;
        long INF = (long) 1e15;

        // distance matrixx
        long[][] dist = new long[ALPHABET][ALPHABET];

        // initialize distances
        for (int i = 0; i < ALPHABET; i++) {
            for (int j = 0; j < ALPHABET; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        // fill direct transformation costs
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall to find all-pairs minimum cost
        for (int k = 0; k < ALPHABET; k++) {
            for (int i = 0; i < ALPHABET; i++) {
                for (int j = 0; j < ALPHABET; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // compute total cost
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (dist[s][t] == INF) return -1;
            totalCost += dist[s][t];
        }

        return totalCost;
    }
}
