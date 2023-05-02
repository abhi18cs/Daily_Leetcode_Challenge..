class Solution {
    public int arraySign(int[] nums) {
    if(nums.length==0) return 0;
            int prod=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) nums[i]=-1;
            else if(nums[i]>0) nums[i]=1;
            prod=prod*nums[i];
            }
            return signFunc(prod);
        }
    
        public static int signFunc(int prod){
            if(prod>0) return 1;
            if(prod<0) return -1;
            else return 0;
        }
}
