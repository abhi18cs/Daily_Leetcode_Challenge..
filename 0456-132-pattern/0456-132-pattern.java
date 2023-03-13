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
        int n=nums.length,third=Integer.MIN_VALUE,top=n;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<third) return true;
            while(top<n && nums[i]>nums[top]){
                third=nums[top++];
            }
                top--;
                nums[top]=nums[i];
        }
            return false;
    }
}