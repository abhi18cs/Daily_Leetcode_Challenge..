class Solution {
    int[][] dp;
    public boolean validPartition(int[] nums) {
        dp = new int[nums.length][4];
        for(int [] x : dp){
            Arrays.fill(x, -1);
        }
        int x = check(nums, 0, 1);
        
        if(x == 1000){
            return false;
        }
        return true;
    }
    int check(int[] nums, int i, int streak){
        if(i == nums.length && streak == 1){
            return 1;
        }
        else if(i == nums.length){
            return 1000;
        }
        if(dp[i][streak] != -1 ){
            return dp[i][streak];
        }
        int ans = 1000;
        if(streak == 1){
           ans = Math.min(ans, check(nums, i + 1, streak + 1));
        }
        else if(streak == 2){
            if(nums[i] != nums[i - 1] && nums[i] - nums[i-1] != 1){
                return 1000;
            }
            if(nums[i] == nums[i - 1]){
                ans = Math.min(check(nums, i + 1, streak + 1), check(nums, i+1, 1));
            }
            else{
                ans = Math.min(ans, check(nums, i+1, streak + 1));
            }
        }
        else if(streak == 3){
                if( (nums[i] - nums[i-1] != 1 || nums[i-1] - nums[i - 2] != 1) && (nums[i] != nums[i -1] || nums[i-1] != nums[i - 2]) ){
                    return 1000;
                }
                ans = Math.min(ans, check(nums, i + 1, 1));
        }
        dp[i][streak] = ans;
        return ans;
    }
}