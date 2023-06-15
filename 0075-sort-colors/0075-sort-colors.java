//Brute Force Using Sort Function Tc=O(nlogn) Sc=O(1)
//Better Approach Tc=O(N+N) Sc=O(1)
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
    for (int i = 0; i < count0; i++) nums[i] =0; // replacing 0's
    for (int i = count0; i < count0 + count1; i++) nums[i] =1; // replacing 1's
    for (int i = count0 + count1; i < n; i++) nums[i] =2; // replacing 2's
    
    }
}


        