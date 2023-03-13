//Approach-1 Brute force with 3 loops tc=O(n^3) sc=O(1)
// class Solution {
//     public boolean find132pattern(int[] nums) {
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 for(int k=j+1;k<nums.length;k++){
//                     if(nums[i] < nums[k] && nums[k] < nums[j])
//                             return true;
//                 }
                
//             }
//         }
//         return false;
//     }
// }

//Approach-2 tc=O(n^2) sc=O(1)
// class Solution {
//     public boolean find132pattern(int[] nums) {
//         for(int j=0,min=Integer.MAX_VALUE;j<nums.length;j++){
//             min=Math.min(nums[j],min);
//             if(min==nums[j]) continue;
//             for(int k=nums.length-1;k>j;k--){
//                 if(min<nums[k] && nums[k]<nums[j]) return true;
//             }
//         }
//         return false;
//     }
// }

//Approach-3 tc=O(n) sc=O(1)
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int third = Integer.MIN_VALUE;
        int top = n;
        
        for (int i = n - 1; i >= 0; i--) {
            // Assumes that third is already smaller than some element nums[j] where j is between i and third's index
            // We find a "132" pattern if nums[i] < third
            if (nums[i] < third) return true;
            
            // Now we have nums[i] >= third
            
            // We now view nums[i] as the second element, and increase third as much as possible, but keep third < nums[i].
            // We do this because we want to maximize the chance of finding a "132" pattern in a future iteration.
            // Note that {nums[top], ..., nums[n-1]} is a stack has the following property:
            // nums[top] <= nums[top+1] <= ... <= nums[n-1]
            while (top < n && nums[i] > nums[top]) third = nums[top++];
            
            // Now we have nums[i] <= nums[top] (which indicates that the stack is monotonical)
            // We push nums[i] to the "stack"            
            top--;
            nums[top] = nums[i];
        }
        
        return false;
    }
}