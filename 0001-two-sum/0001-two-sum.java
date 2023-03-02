//brute force tc=o(n2) sc=O(2)
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int a[]=new int [2];
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]+nums[j]==target){
//                     a[0]=i;
//                     a[1]=j;
//                 }
//             }
//         }
//         return a;
//     }
// }

//optimized approach using 2 pointers tc=o(nlogn) sc=O(2)
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//       int p1=0;
//       int a[]=new int[2];
//       int p2=nums.length-1;
//       while(p1<p2){
//           if(nums[p1]+nums[p2]==target){
//               a[0]=p1;
//               a[1]=p2;
//               break;
//             }
//           else if((nums[p1]+nums[p2])>target) p2--;
//           else p1++;
//         }
//       return a;
//     }
// }

//approach-3 using hashmap tc=O(n) sc=O(2)
class Solution{
    public int[] twoSum(int[] nums, int target) {
        int a[]=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                a[0]=i;
                a[1]=map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
    return a;
    }
}