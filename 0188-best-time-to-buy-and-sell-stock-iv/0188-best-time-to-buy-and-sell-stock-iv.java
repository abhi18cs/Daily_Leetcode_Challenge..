//Approach-1 NaiveApproach  Tc=O(n2 * k) Sc=O(n * k)
class Solution {
	int maxProfit(int k,int[] prices) {
	    int n = prices.length;
		int profit[][] = new int[k + 1][n + 1];
		for (int i = 0; i <= k; i++) {
			profit[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			profit[0][i] = 0;
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				int currMax = Integer.MIN_VALUE;
				for (int day = 0; day < j; day++) {
					currMax = Math.max(currMax, prices[j] - prices[day] + profit[i - 1][day]);
				}
				profit[i][j] = Math.max(profit[i][j - 1], currMax);
			}
		}
		return profit[k][n - 1];
	}
}
//Approach-1 Recursive TLE Tc=O(2^n) Sc=O(n)
// class Solution{
//     public int maxProfit(int k,int[] prices){
//         return solve(0,1,prices,k);
//     }
//     public int solve(int index,int buy,int[] prices,int limit){
//         if(index==prices.length) return 0;
//         if(limit==0) return 0;
//         int profit=0;
//         //buy=1(Allowed),buy=0(Not allowed)
//         if(buy==1){
//             buy=-prices[index]+solve(index+1,0,prices,limit);
//             int skip=0+solve(index+1,1,prices,limit);
//             profit=Math.max(buy,skip);
//         }
//         else{
//             int sell=prices[index]+solve(index+1,1,prices,limit-1);
//             int skip=0+solve(index+1,0,prices,limit);
//             profit=Math.max(sell,skip);
//         }
//         return profit;
//     }
// }

// //Approach-2 USing Recursion+Memoization(TopDownApproach) Tc=O(n*2*k) Sc=O(n*2*k)+O(n)
// class Solution {  
//     int[][][]dp;
//     public int maxProfit(int k,int[] prices) {
//        int n = prices.length;
//         dp = new int[n][2][k+1];
         
//         //return solve(0, prices, 1, dp, n, 2);
//          return solve(0,prices,1,dp,n,k);
//     }
    
//     public int solve(int index,int[] prices,int buy,int[][][] dp,int n,int k){
//         if(index==prices.length) return 0;
//         if(k==0) return 0;
//         if(dp[index][buy][k]!=0) return dp[index][buy][k];
//         int profit=0;
//         //buy=1(Allowed),buy=0(Not allowed)
//         if(buy==1){
//             profit=Math.max(-prices[index]+solve(index+1,prices,0,dp,n,k),
//                             0+solve(index+1,prices,1,dp,n,k));
//         }
//         else{
//             profit=Math.max(prices[index]+solve(index+1,prices,1,dp,n,k-1),
//                             0+solve(index+1,prices,0,dp,n,k));
//         }
//         dp[index][buy][k]=profit;
//         return dp[index][buy][k];
//     }
// }


//Approach-3 USing Tabulation(BottomUpApproach) Tc=O(n*2*k) Sc=O(n*2*k)+O(n)
// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int[][][] dp = new int[n+1][2][k+1];
//         for(int i = n-1; i >= 0; i--){
//             for(int buy = 0; buy < 2; buy++){
//                 for(int cap = 1; cap < k+1; cap++){
//                     if(i==n || k==0) return 0;
//                     if(buy == 1){
//                         dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap]
//                                                             , 0 + dp[i+1][1][cap]);                     
//                         }
//                     else{
//                         dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1]
//                                                             , 0 + dp[i+1][0][cap]);
//                     }
//                 }
//             }
//         }
//         return dp[0][1][k];
//     }
// }

//Approach-4 Using (Space optimiztion) Tc=O(n*2)==O(n) Sc=O(2*3)==O(1)
// class Solution {
//     public int maxProfit(int k,int[] prices) {
//         int n = prices.length;
//         int[][] after = new int[2][k+1];
//         int[][] curr = new int[2][k+1];
        
//         for(int i=n-1; i>=0; i--){
//             for(int buy=0; buy<=1; buy++){
//                 for(int c=1; c<=k; c++){
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
//         return curr[1][k];
//     }
// }

//fastest solution
// class Solution{
//     public int maxProfit(int k, int[] prices) {
//            int profit[] = new int[k];
//            int cost[] = new int[k];
//            Arrays.fill(cost, Integer.MAX_VALUE);
//            for(int currPrice : prices){
//                 cost[0] = Math.min(cost[0], currPrice);
//                 profit[0] = Math.max(profit[0], currPrice-cost[0]);
//                 for(int j = 1;  j < k; j++){
//                     cost[j] = Math.min(cost[j], currPrice - profit[j-1]);
//                     profit[j] = Math.max(profit[j], currPrice - cost[j]);
//                 }
//            }
//            return profit[k-1];
//        }
// }