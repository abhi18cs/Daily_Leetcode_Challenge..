class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int pod=1;
            for(int j=i;j<nums.length;j++){
                pod=pod*nums[j];
                if(pod<k) count++;
                else break;
            }
        }
        return count;
    }
}