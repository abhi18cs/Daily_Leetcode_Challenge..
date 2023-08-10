//Approach-1 tc=O(n) sc=O(1); 
// class Solution {
//     public void moveZeroes(int[] nums) {
//         if(nums==null || nums.length==1) return;
//         int j=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]!=0){
//                 int temp=nums[i];
//                 nums[i]=nums[j];
//                 nums[j]=temp;
//                 j++;
//             }
//         }
        
//     }
// }

//Approach-2 Using 2 pointers 
class Solution {
    public void moveZeroes(int[] nums) {
        int p1=0,p2=0;
        while(p1<nums.length){
            if(nums[p1]==0)
                p1++;
            else{
                int temp=nums[p1];
                nums[p1]=nums[p2];
                nums[p2]=temp;
                p1++;
                p2++;
            }
        }
    }
}