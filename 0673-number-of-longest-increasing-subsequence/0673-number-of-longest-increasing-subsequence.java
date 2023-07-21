class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int maxLength=0;
        for(int i=0;i<nums.length;i++) {
            dp[i]=1;
            count[i]=1;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) {
                    //if current element can be added to dp array.
                    if(dp[i]<dp[j]+1) {
                        dp[i]=dp[j]+1;
                        //count is copied directly bcz, it is creating new sequence by adding jth element. and hence whatever the count of lis j has, now i will also has
                        count[i]=count[j];
                    } else if(dp[i]==dp[j]+1) {
                        //it means same length lis found again. hence update count wih total occurence of jth element.
                        count[i]+=count[j];
                    } 
                }
            }
            //hold overall max length lis
            maxLength=Math.max(maxLength,dp[i]);
        }
    //once we have maxLength ready. we can check which indexes has same max length. and just add count of such indexes.
        int ans=0;
        for(int i=0;i<dp.length;i++) {
            if(dp[i]==maxLength) {
                ans+=count[i];
            }
        }
        return ans;
    }
}