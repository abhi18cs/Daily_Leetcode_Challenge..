class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums); // Sort the array to ensure distinct integers
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[left++];
            } else {
                res[i] = nums[right--];
            }
        }
        return res;
    }
}
