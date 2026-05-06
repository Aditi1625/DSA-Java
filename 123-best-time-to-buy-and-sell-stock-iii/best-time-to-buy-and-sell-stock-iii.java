class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);              // first buy
            sell1 = Math.max(sell1, price - buy1);     // first sell
            
            buy2 = Math.min(buy2, price - sell1);      // second buy
            sell2 = Math.max(sell2, price - buy2);     // second sell
        }

        return sell2;
    }
}