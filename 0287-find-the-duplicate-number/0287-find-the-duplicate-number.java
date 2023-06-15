//Brute Force Using Sorting TC=O(nlogn+n) SC=O(1)
// class Solution{
//     public int findDuplicate(int[] nums){
//         Arrays.sort(nums);
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==nums[i+1])
//                 return nums[i];
//         }
//         return -1;
//     }
// }

//Better Approach Tc=O(n) Sc=O(n) using hashmap
// class Solution {
//     public int findDuplicate(int[] nums) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             if(!map.containsKey(nums[i]))
//                 map.put(nums[i],1);//1st time;
//             else{
//                 map.put(nums[i],2); //2nd time
//             }
//         }
//             int res=-1;
//             for(int ele:nums){
//                 if(map.get(ele)==2){
//                     res=ele;
//                     break;
//                 }
//             }
//         return res;    
//     }
// }

//Optimal Approach USing LinkedList Cycle Method Tc=O(N) Sc=O(1) 
class Solution{
    public static int findDuplicate(int[] nums){
        int slow=nums[0],fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}


// Optimal Approach TC=O(N) SC=O(1) Visited
// class Solution{
//     public static int findDuplicate(int[] nums) {
//         int len = nums.length;
//         for (int num : nums) {
//             int idx = Math.abs(num);
//             if (nums[idx] < 0) {
//                 return idx;
//             }
//             nums[idx] = -nums[idx];
//         }

//         return len;
//     }
// }