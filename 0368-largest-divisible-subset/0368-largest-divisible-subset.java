class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;

                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int currentSize = maxSize;
        int currentNumber = nums[maxIndex];

        for (int i = maxIndex; i >= 0; i--) {
            if (currentNumber % nums[i] == 0 && dp[i] == currentSize) {
                result.add(nums[i]);
                currentNumber = nums[i];
                currentSize--;
            }
        }

        return result;
    }
}