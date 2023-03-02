class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0, n = nums.length, end = n - 1;
        while (start <= end) {
            if (nums[start] + nums[end] == target) {
                return new int[] { start + 1, end + 1 };
            } else if ((nums[start] + nums[end]) < target) {
                start++;
            } else
                end--;
        }
        return new int[] {};
    }
}