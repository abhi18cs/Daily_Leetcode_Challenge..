//Approach-1 Brute Force Tc=O(n2) Sc=O(1)
// class Solution{
//     public int maxProfit(int[] prices) {
//         int maxProfit = 0;
//         int n = prices.length;

//         for (int i = 0; i < n; i++) {
//             int profit1 = maxProfitSingle(prices, 0, i); // Get the max profit for the first half of the array
//             int profit2 = maxProfitSingle(prices, i + 1, n - 1); // Get the max profit for the second half of the array
//             int totalProfit = profit1 + profit2; // Calculate the total profit that can be made by buying and selling twice
//             maxProfit = Math.max(maxProfit, totalProfit); // Update the max profit seen so far
//         }

//         return maxProfit;
//     }

// public int maxProfitSingle(int[] prices, int start, int end) {
//     int minPrice = Integer.MAX_VALUE; // Start with the maximum possible value for the minimum price
//     int maxProfit = 0; // Start with zero profit

//     for (int i = start; i <= end; i++) {
//         if (prices[i] < minPrice) { // If the current price is lower than the current minimum price, update the minimum price
//             minPrice = prices[i];
//         } else if (prices[i] - minPrice > maxProfit) { // If the current price minus the current minimum price is greater than the current max profit, update the max profit
//             maxProfit = prices[i] - minPrice;
//         }
//     }

//     return maxProfit; // Return the max profit that can be made by buying and selling once in the given range of prices
// }
// }


//Approach-1 USing Recursion+Memoization(TopDownApproach)
// class Solution {
//     int[][][] dp;
    
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         dp = new int[n][2][3];  // initialize the 3-dimensional dp array
        
//         return find(0, 1, 2, prices);
//     }
    
//     public int find(int i, int buy, int c, int[] arr){
//         if(i == arr.length || c == 0)  return 0;
//         if(dp[i][buy][c] != 0)  return dp[i][buy][c];  
//         // if the result of this subproblem has already been computed, return it
        
//         if(buy == 1){
// 			return dp[i][buy][c] = Math.max(-arr[i] + find(i+1, 0, c, arr), find(i+1, 1, c, arr));     // Here we have choice to whether choose that element or not, and after that, the part giving maximum profit after buying(be that negative) is taken
//         }
//         else{
//             return dp[i][buy][c] = Math.max(arr[i] + find(i+1, 1, c-1, arr), find(i+1, 0, c, arr));   // Same as above but the only change is that profit added is positive because we are selling this time.
//         }
//     }   
// }

//Approach-2 Using (Space optimiztion)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] after = new int[2][3];
//         int[][] curr = new int[2][3];
        
//         for(int i=n-1; i>=0; i--){
//             for(int buy=0; buy<=1; buy++){
//                 for(int c=1; c<=2; c++){
//                     if(buy == 1){
// 						curr[buy][c] = Math.max(-prices[i] + after[0][c], after[1][c]);    // This approach requires O(1) space because we identified that the current state only depends on previous state so its not necessary to store whole 3D array
// 					// We only require two 2x3 matrix to store these states
//                     }
//                     else{
//                         curr[buy][c] = Math.max(prices[i] + after[1][c-1], after[0][c]);
//                     }
//                 }
//             }
//             after = curr;
//         }
//         return curr[1][2];
//     }
// }



class Solution{
public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n < 2) {
        return 0;
    }
    
    int[][] buy = new int[3][n];
    int[][] sell = new int[3][n];
    
    for (int k = 1; k <= 2; k++) {
        buy[k][0] = -prices[0];
        sell[k][0] = 0;
        for (int i = 1; i < n; i++) {
            buy[k][i] = Math.max(buy[k][i-1], sell[k-1][i-1] - prices[i]);
            sell[k][i] = Math.max(sell[k][i-1], buy[k][i-1] + prices[i]);
        }
    }
    
    return sell[2][n-1];
}
}