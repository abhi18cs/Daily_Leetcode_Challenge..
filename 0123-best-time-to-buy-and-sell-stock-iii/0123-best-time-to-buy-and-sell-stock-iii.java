//Approach-1 Recursive TLE Tc=O(2^n) Sc=O(n)
// class Solution{
//     public int maxProfit(int[] prices){
//         return solve(0,1,prices,2);
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


//Approach-2 USing Recursion+Memoization(TopDownApproach) Tc=O(n*2*3) Sc=O(n*2*3)+O(n)
class Solution {    
    public int maxProfit(int[] prices) {
       int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<2; j++){
                Arrays.fill(dp[i][j], -1);      
            }
        } 
        //return solve(0, prices, 1, dp, n, 2);
         return solve(0,prices,1,dp,n,2);
    }
    
    public int solve(int index,int[] prices,int buy,int[][][] dp,int n,int k){
        if(index==prices.length) return 0;
        if(k==0) return 0;
        if(dp[index][buy][k]!=-1) return dp[index][buy][k];
        int profit=0;
        //buy=1(Allowed),buy=0(Not allowed)
        if(buy==1){
            profit=Math.max(-prices[index]+solve(index+1,prices,0,dp,n,k),
                            0+solve(index+1,prices,1,dp,n,k));
        }
        else{
            profit=Math.max(prices[index]+solve(index+1,prices,1,dp,n,k-1),
                            0+solve(index+1,prices,0,dp,n,k));
        }
        dp[index][buy][k]=profit;
        return dp[index][buy][k];
    }
}






// Approach-3 Using (Space optimiztion)
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



// class Solution{
// public int maxProfit(int[] prices) {
//     int n = prices.length;
//     if (n < 2) {
//         return 0;
//     }
    
//     int[][] buy = new int[3][n];
//     int[][] sell = new int[3][n];
    
//     for (int k = 1; k <= 2; k++) {
//         buy[k][0] = -prices[0];
//         sell[k][0] = 0;
//         for (int i = 1; i < n; i++) {
//             buy[k][i] = Math.max(buy[k][i-1], sell[k-1][i-1] - prices[i]);
//             sell[k][i] = Math.max(sell[k][i-1], buy[k][i-1] + prices[i]);
//         }
//     }
    
//     return sell[2][n-1];
// }
// }