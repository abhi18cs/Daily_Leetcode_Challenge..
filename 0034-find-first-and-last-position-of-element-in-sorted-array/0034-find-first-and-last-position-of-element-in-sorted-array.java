class Solution {
    public int[] searchRange(int[] nums, int target) {
       int l=firstGreaterValue(nums,target);
        if(l==nums.length || nums[l]!=target) return new int[]{-1,-1};
        return new int[]{l,firstGreaterValue(nums,target+1)-1};
        
    }
    //find the first number that is greater than or equal to target.
	//could return nums.length if target is greater than nums[nums.length-1].
	//actually this is the same as lower_bound in C++ STL.
    public static int firstGreaterValue(int[] nums, int target) {
        int l=0,h=nums.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(nums[m]<target) l=m+1;
            //should not be mid-1 when A[mid]==target.
			//could be mid even if A[mid]>target because mid<high.
            else h=m;
            
        }
        return l;
    }
}
