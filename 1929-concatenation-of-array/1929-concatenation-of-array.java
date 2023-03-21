class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int ans[]=new int [2*n];
        for( int i=0;i<n;i++){
            //first half of output array
            ans[i]=nums[i];
            //second half of output array
            ans[i+n]=nums[i];
        }
        return ans;
    }
}