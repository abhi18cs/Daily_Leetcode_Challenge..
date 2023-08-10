//tc=O(n) sc=O(1)
class Solution {
        public int missingNumber(int[] nums) {
        //sum of first n natural numbers
        int n=nums.length,totalsum=n*(n+1)/2; 
        // for(int i:nums)
        //     totalsum-=i;
        // return totalsum;
        for(int i=0;i<nums.length;i++){
            totalsum-=nums[i];
        }
        return totalsum;
    }
}