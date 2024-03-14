class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //loop through nums
        //for each index, recursively call the subArraySum function
        //if index >= nums.length 
          //check if target == sum
            //increment count if yes
          //return 

        int numSubArraysWithTargetSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == goal) {
                numSubArraysWithTargetSum++;

            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    numSubArraysWithTargetSum++;

                }

                if (sum > goal) break;
            }
        }

        return numSubArraysWithTargetSum;
    }
}