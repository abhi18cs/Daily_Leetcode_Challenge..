class Solution {
int mod=1000000007;
public int numWays(int steps, int arrLen) {
    
    int[]dp= new int[arrLen];
    dp[0]=1;
    for(int i=1;i<=steps;i++){
        int prev=0;
      l1:  for(int j=0;j<arrLen;j++){
            int x=dp[j];
              dp[j]+=prev;
              dp[j]%=1000000007;
            
            if(j<arrLen-1){
            dp[j]+=dp[j+1];
            dp[j]%=1000000007;
            }
            if(dp[j]==0)break l1;
            prev=x;
        }
    }
    return dp[0];
}
}

