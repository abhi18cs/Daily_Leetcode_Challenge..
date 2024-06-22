class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1); // Base case: a sum of zero exists once
        
        for (int num : nums) {
            prefixSum += num % 2; // Increment prefix sum if the number is odd
            
            // If prefixSum - k exists in the map, it means there are subarrays
            // ending at the current index which have exactly k odd numbers.
            count += prefixCounts.getOrDefault(prefixSum - k, 0);
            
            // Increment the count of this prefix sum in the map
            prefixCounts.put(prefixSum, prefixCounts.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}