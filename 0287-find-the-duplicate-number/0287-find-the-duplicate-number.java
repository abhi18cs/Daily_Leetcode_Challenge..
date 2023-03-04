// TC=O(n) SC=O(n) using hashmap
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

// TC=O(N) SC=O(1) Visited
class Solution{
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }

        return len;
    }
}