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


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];
        
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int c=1; c<=2; c++){
                    if(buy == 1){
						curr[buy][c] = Math.max(-prices[i] + after[0][c], after[1][c]);    // This approach requires O(1) space because we identified that the current state only depends on previous state so its not necessary to store whole 3D array
					// We only require two 2x3 matrix to store these states
                    }
                    else{
                        curr[buy][c] = Math.max(prices[i] + after[1][c-1], after[0][c]);
                    }
                }
            }
            after = curr;
        }
        return curr[1][2];
    }
}