class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans1=nums[0]*nums[1]*nums[nums.length-1];
        int ans2=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int maxAns=Math.max(ans1,ans2);
        return maxAns;
    }
}