
class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Math.min(prices[0], prices[1]);
        int secondMin = Math.max(prices[0], prices[1]);

        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < min) {
                secondMin = min;
                min = prices[i];
            } else if (prices[i] < secondMin) {
                secondMin = prices[i];
            }
        }

        int minCost = min + secondMin;

        if (minCost <= money) {
            return money - minCost;
        } else {
            return money;
        }
    }
}