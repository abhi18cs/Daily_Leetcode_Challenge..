class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
      double[] dp = new double[100];
        dp[0] = poured;
        for (int i = 1; i <= query_row; i++)
        {
		    // in order to save space, we have to calculate from the end to the start
            for (int j = i-1; j >= 0; j--)
            {
			    // this is the half of the remain and wil be poured to the next level
                double remain = (Math.max(dp[j], 1.0) - 1.0) / 2.0;
				
				// this includes the champagne from the previous calculation, we need to use add
                dp[j+1] += remain;
				
				// This is all champagne poured for this glass
                dp[j] = remain;
            }
        }
        return dp[query_glass] >= 1 ? 1: dp[query_glass];  
    }
}