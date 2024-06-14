class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums); // Sort the array first
        int res = 0; // This will store the result, the total increments needed

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                int diff = nums[i - 1] - nums[i] + 1; // Calculate the difference needed to make the current element unique
                res += diff; // Add this difference to the result
                nums[i] += diff; // Update the current element to its new unique value
            }
        }

        return res; // Return the total increments needed
    }
}