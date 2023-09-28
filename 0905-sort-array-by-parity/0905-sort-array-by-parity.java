class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                j++;
            }
        }
       return nums; 
    }
}