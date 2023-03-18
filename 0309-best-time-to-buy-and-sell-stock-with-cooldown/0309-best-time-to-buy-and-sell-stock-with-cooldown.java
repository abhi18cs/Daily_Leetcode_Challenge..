//Tc=O(n) Sc=O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int buy = -prices[0];
        int sell = 0;
        int prevSell = 0;
        for (int i = 1; i < prices.length; i++) {
            // buy[i] = Math.max(sell[i-2]-prices[i], buy[i-1])
            // sell[i-2]-prices[i] -> Buy after a 1 day cooldown
            // buy[i-1] -> cooldown
            buy = Math.max(prevSell - prices[i], buy);
            // sell[i-1];
            prevSell = sell;
            // sell[i] = Math.max(buy[i]+prices, sell[i-1])
            // buy[i]+prices -> sell the stock.
            // sell[i-1] -> cooldown
            sell = Math.max(buy + prices[i], sell);
        }
        return sell;
    }
}