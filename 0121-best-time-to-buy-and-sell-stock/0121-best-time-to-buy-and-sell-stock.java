class Solution {
    public int maxProfit(int[] prices) {
        int bPrice = prices[0]; //cheapest stock seen till now
        int profit = 0; // best profit seen till now
        for (int i = 1; i < prices.length; i++) {
            if (bPrice > prices[i]) {
                bPrice = prices[i]; // bought at that time
            }
            profit = Math.max(profit, prices[i]-bPrice); // computing profit
        }
        return profit;        
    }
}