//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/1569081/Java-Simple-and-Clean-DP-solutions-for-all-6-Buy-and-Sell-Stock-questions-on-LeetCode
//Approach-1 iterative BruteForce Tc=O(n2) Sc=O(1)
class Solution {
    public int maxProfit(int[] prices) {
    int n = prices.length;
    int maxProfit=0;
    int sum=0;
    for(int i=0; i<n; i++){
        for(int j=i+1; j<n && prices[j]>prices[i]; j++){
            sum += prices[j]-prices[i];
            if(sum>maxProfit)
                maxProfit = sum;
                    break;
            }
        }
            return maxProfit;
    }
}

//Tc=O(n) Sc=O(1)
// class Solution {
//     public int maxProfit(int[] prices) {
// 		// We need prices for 2 days at least to find the profit.
//         if (prices == null || prices.length <= 1) {
//             return 0;
//         }

//         int totalProfit = 0;
//         for (int i = 1; i < prices.length; i++) {
//             // Checking if we can profit with previous day's price.
//             // If yes, then we buy on previous day and sell on current day.
//             // Add all such profits to get the total profit.
//             if (prices[i - 1] < prices[i]) {
//                 totalProfit += prices[i] - prices[i - 1];
//             }
//         }

//         return totalProfit;
//     }
// }