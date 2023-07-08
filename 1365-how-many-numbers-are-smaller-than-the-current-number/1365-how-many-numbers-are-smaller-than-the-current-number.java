//Approach-1 BruteForce Traversing through each element Tc=O(n^2) Sc=O(n)
// class Solution {
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         int arr[]=new int [nums.length];
//         int count=0;
//         for(int i=0;i<nums.length;i++){
//             for(int j=0;j<nums.length;j++){
//                 if(j!=i && nums[i]>nums[j]) count++;
//             }
//             arr[i]=count;
//             count=0;
//         }
//         return arr;
//     }
// }
//Approach-2 OptimiziedApproach count the number occurrences of each number Tc=O(n) Sc=O(n)
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket = new int[102];
        for(int i=0; i<nums.length; i++)
            bucket[nums[i]+1]++;
			
        for(int i=0; i<101; i++) 
            bucket[i+1] += bucket[i];
			
        for(int i=0; i<nums.length; i++)
            nums[i] = bucket[nums[i]];
			
        return nums;
    }
}
