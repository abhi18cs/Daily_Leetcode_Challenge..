//Approach Using Binary Search tc=O(logn) sc=O(1)
class Solution {
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]==target) return m;
            if(nums[m]>=nums[l]){
                if(target<=nums[m] && target>=nums[l]){
                    h=m-1;
                }
                else{
                    l=m+1;
                }
            }
            else{
                
                if(target>=nums[m] && target<=nums[h]){
                    l=m+1;
                }
                else{
                    h=m-1;
                }
            }
            
        }
        return -1;
    }
}			
				