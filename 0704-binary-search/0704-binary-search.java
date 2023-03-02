//tc=O(n) sc=O(1) using binary search
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int n=nums.length;
        int l=0;
        int h=n-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]==target)
                return m;
            if(nums[m]>target) h=m-1;
            else {
               
                l=m+1;
            }
        }
        return -1;
    }
}
