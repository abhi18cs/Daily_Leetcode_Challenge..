//Approach-1 Brute force Tc=o(n2) Sc=O(2)
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

//Approach-2 Better Approach Using 2 pointers Tc=o(nlogn) Sc=O(2)
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

//Approach-3 Optimal Approach Using Hashmap Tc=O(n) Sc=O(2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a[] = new int[2]; // Create an array to store the indices of the two numbers
        // Create a HashMap to store the numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();
        // Iterate through the array of numbers
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                // If the complement of the current number exists in the map, we found a pair that adds up to the target
                // Set the indices in the result array
                a[0] = i; // Index of the current number
                a[1] = map.get(target - nums[i]); // Index of the complement number
                // No need to continue iterating, so we break out of the loop
                break;
            }
            // Store the current number and its index in the map
            map.put(nums[i], i);
        }
        // Return the array containing the indices of the two numbers
        return a;
    }
}
