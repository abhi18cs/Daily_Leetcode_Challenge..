//Approach-1 UsingSorting Tc=O(n) Sc=O(1);
//In "case1," we consider the possibility of negative numbers impacting the maximum product calculation. We multiply the two smallest numbers (nums[0] and nums[1]) in the sorted array by the largest number (nums[nums.length-1]). This accounts for the scenario where multiplying two negative numbers results in a positive product.In "case2," we calculate the product of the three largest numbers in the sorted array (nums[nums.length-1], nums[nums.length-2], and nums[nums.length-3]).By comparing the products calculated in "case1" and "case2," we determine the maximum product and assign it to the variable ans.

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans1=nums[0]*nums[1]*nums[nums.length-1];
        int ans2=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int maxAns=Math.max(ans1,ans2);
        return maxAns;
    }
}