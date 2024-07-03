class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            res = Math.min(res, nums[n - 1 - 3 + i] - nums[i]);
        }
        return res;
    }
}