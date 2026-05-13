class Solution {

    List<Integer>[] tree;
    int[] present, future;
    int B;

    public int maxProfit(int n, int[] present, int[] future,
                         int[][] hierarchy, int budget) {

        this.present = present;
        this.future = future;
        this.B = budget;

        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] e : hierarchy) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            tree[u].add(v);
        }

        long[][] ans = dfs(0);

        long res = 0;

        for (int b = 0; b <= budget; b++) {
            res = Math.max(res, ans[0][b]);
        }

        return (int) res;
    }

    /*
        dp[0][b] -> max profit for subtree if parent NOT bought
        dp[1][b] -> max profit for subtree if parent bought
    */

    private long[][] dfs(int u) {

        long NEG = -(long) 1e18;

        long[][] dp = new long[2][B + 1];

        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], NEG);
        }

        // ---------- parent NOT bought ----------

        int fullCost = present[u];
        int fullProfit = future[u] - fullCost;

        long[] noDiscount = new long[B + 1];
        long[] buyFull = new long[B + 1];

        Arrays.fill(noDiscount, NEG);
        Arrays.fill(buyFull, NEG);

        noDiscount[0] = 0;

        if (fullCost <= B) {
            buyFull[fullCost] = fullProfit;
        }

        // ---------- parent bought ----------

        int discCost = present[u] / 2;
        int discProfit = future[u] - discCost;

        long[] withDiscount = new long[B + 1];
        long[] buyDisc = new long[B + 1];

        Arrays.fill(withDiscount, NEG);
        Arrays.fill(buyDisc, NEG);

        withDiscount[0] = 0;

        if (discCost <= B) {
            buyDisc[discCost] = discProfit;
        }

        for (int v : tree[u]) {

            long[][] child = dfs(v);

            long[] nextNoDiscount = new long[B + 1];
            long[] nextBuyFull = new long[B + 1];

            long[] nextWithDiscount = new long[B + 1];
            long[] nextBuyDisc = new long[B + 1];

            Arrays.fill(nextNoDiscount, NEG);
            Arrays.fill(nextBuyFull, NEG);
            Arrays.fill(nextWithDiscount, NEG);
            Arrays.fill(nextBuyDisc, NEG);

            // u NOT bought -> child gets NO discount
            for (int b1 = 0; b1 <= B; b1++) {

                if (noDiscount[b1] == NEG) continue;

                for (int b2 = 0; b1 + b2 <= B; b2++) {

                    if (child[0][b2] == NEG) continue;

                    nextNoDiscount[b1 + b2] = Math.max(
                        nextNoDiscount[b1 + b2],
                        noDiscount[b1] + child[0][b2]
                    );
                }
            }

            // u bought at full price -> child gets discount
            for (int b1 = 0; b1 <= B; b1++) {

                if (buyFull[b1] == NEG) continue;

                for (int b2 = 0; b1 + b2 <= B; b2++) {

                    if (child[1][b2] == NEG) continue;

                    nextBuyFull[b1 + b2] = Math.max(
                        nextBuyFull[b1 + b2],
                        buyFull[b1] + child[1][b2]
                    );
                }
            }

            // u NOT bought (but parent bought)
            // child still gets NO discount
            for (int b1 = 0; b1 <= B; b1++) {

                if (withDiscount[b1] == NEG) continue;

                for (int b2 = 0; b1 + b2 <= B; b2++) {

                    if (child[0][b2] == NEG) continue;

                    nextWithDiscount[b1 + b2] = Math.max(
                        nextWithDiscount[b1 + b2],
                        withDiscount[b1] + child[0][b2]
                    );
                }
            }

            // u bought with discount -> child gets discount
            for (int b1 = 0; b1 <= B; b1++) {

                if (buyDisc[b1] == NEG) continue;

                for (int b2 = 0; b1 + b2 <= B; b2++) {

                    if (child[1][b2] == NEG) continue;

                    nextBuyDisc[b1 + b2] = Math.max(
                        nextBuyDisc[b1 + b2],
                        buyDisc[b1] + child[1][b2]
                    );
                }
            }

            noDiscount = nextNoDiscount;
            buyFull = nextBuyFull;

            withDiscount = nextWithDiscount;
            buyDisc = nextBuyDisc;
        }

        for (int b = 0; b <= B; b++) {

            dp[0][b] = Math.max(
                noDiscount[b],
                buyFull[b]
            );

            dp[1][b] = Math.max(
                withDiscount[b],
                buyDisc[b]
            );
        }

        return dp;
    }
}