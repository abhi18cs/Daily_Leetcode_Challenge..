class Solution {
    int[][][] dp;
    public int maxProfit(int c, int[] prices) {
        int n = prices.length;
        dp = new int[n][2][c+1];  // initialize the 3-dimensional dp array
        
        return find(0, 1, c, prices);
    }
    
    private int find(int i, int buy, int c, int[] arr){
        if(i == arr.length || c == 0)  return 0;
        if(dp[i][buy][c] != 0)  return dp[i][buy][c];  
        // if the result of this subproblem has already been computed, return it
        
        if(buy == 1){
			return dp[i][buy][c] = Math.max(-arr[i] + find(i+1, 0, c, arr), find(i+1, 1, c, arr));     // Here we have choice to whether choose that element or not, and after that, the part giving maximum profit after buying(be that negative) is taken
        }
        else{
            return dp[i][buy][c] = Math.max(arr[i] + find(i+1, 1, c-1, arr), find(i+1, 0, c, arr));   // Same as above but the only change is that profit added is positive because we are selling this time.
        }
    }
}