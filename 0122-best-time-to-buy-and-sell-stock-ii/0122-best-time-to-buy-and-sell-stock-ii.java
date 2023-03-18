//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/1569081/Java-Simple-and-Clean-DP-solutions-for-all-6-Buy-and-Sell-Stock-questions-on-LeetCode
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int totalProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                totalProfit+=prices[i]-prices[i-1];
            }
        }
        return totalProfit;
    }
}