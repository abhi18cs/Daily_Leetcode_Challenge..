//Brute Force tc=O(nlogn) sc=O(1)
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums.length==0) return 0;
//         Arrays.sort(nums);
//         int count=1;
//         int max=0;
//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i]==nums[i+1]) continue;
//             if(nums[i]==nums[i+1]-1){
//             count++;
//             max=Math.max(max,count);
//             }
//             else count=1;
//         }
//         return Math.max(max,count);
//     }
// }

//Optimized Approach tc=O(n) sc=O(n)
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         //intialize the hashset and store all the elemnts in that
//         HashSet<Integer> hashset=new HashSet<>();
//         for(int num:nums){
//             hashset.add(num);
//         }
//         int longestSequence=0;
//         for(int num:nums){
//             if(!hashset.contains(num-1)){
//                 int currElement=num;
//                 int currSequence=1;
//                 while(hashset.contains(currElement+1)){
//                     currElement++;
//                     currSequence++;
//                 }
            
//         longestSequence=Math.max(currSequence,longestSequence);
//             }
//         }
//         return longestSequence;
//     }
// }

//Another approach using hashset Using a set to collect all elements that hasn't been visited. search element will be O(1) and eliminates visiting element again.
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int num: nums) set.add(num);
        int max = 1;
        for(int num: nums) {
            if(set.remove(num)) {//num hasn't been visited
                int val = num;
                int sum = 1;
                while(set.remove(val-1)) val--;
                sum += num - val;
                
                val = num;
                while(set.remove(val+1)) val++;
                sum += val - num;
                
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}