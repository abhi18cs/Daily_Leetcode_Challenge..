class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if((i==0 || nums[i-1]==0 ) && (i==nums.length-1 || nums[i+1]==0)) {
                    n--;
                    nums[i]=1; //fill this index with a 1 for future checks
                }
            }
        }
         
        return (n<=0); //if you could place more than n flowers, it is still acceptable
    }
}