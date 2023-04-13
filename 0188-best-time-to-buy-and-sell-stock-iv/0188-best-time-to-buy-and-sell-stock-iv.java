
// class Solution {    
//     public int maxProfit(int k,int[] prices) {
//        int n = prices.length;
//         int[][][] dp = new int[n][2][k+1];
       
//         //return solve(0, prices, 1, dp, n, 2);
//          return solve(0,prices,1,dp,n,k);
//     }
    
//     public int solve(int index,int[] prices,int buy,int[][][] dp,int n,int k){
//         if(index==prices.length) return 0;
//         if(k==0) return 0;
//         if(dp[index][buy][k]!=-1) return dp[index][buy][k];
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
//         return profit;
//     }
// }





class Solution {
    int[][][] dp;
    public int maxProfit(int c, int[] prices) {
        int n = prices.length;
        dp = new int[n][2][c+1];  // initialize the 3-dimensional dp array
        
        return find(0, 1, c, prices);
    }
    
    private int find(int i, int buy, int c, int[] arr){
        if(i == arr.length || c == 0)  return 0;
//if the result of this subproblem has already been computed, return it
        if(dp[i][buy][c] != 0)  return dp[i][buy][c];  
        
        
        if(buy == 1){
			return dp[i][buy][c] = Math.max(-arr[i] + find(i+1, 0, c, arr), find(i+1, 1, c, arr));     // Here we have choice to whether choose that element or not, and after that, the part giving maximum profit after buying(be that negative) is taken
        }
        else{
            return dp[i][buy][c] = Math.max(arr[i] + find(i+1, 1, c-1, arr), find(i+1, 0, c, arr));   // Same as above but the only change is that profit added is positive because we are selling this time.
        }
    }
}

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