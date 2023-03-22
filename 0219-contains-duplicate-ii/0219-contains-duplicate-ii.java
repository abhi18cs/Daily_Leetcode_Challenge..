//Approach-1 Brute Force Tc=O(n^2) Sc=O(1) [TLE]
// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//             if(nums[i]==nums[j] && Math.abs(i-j)<=k)
//                 return true;
//             }
//         }
//     return false;   
//     }
// }

//Approach-2 Using HashMap Tc=O(n) Sc=O(n)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if((i-map.get(nums[i])) <= k) return true;
            }
                   map.put(nums[i],i);
            
        }
    return false;   
    }
}


//Approach-3 Using HashSet Sliding Window Tc=O(n) Sc=O(n)
// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//     Set<Integer> set = new HashSet<Integer>();
//         for(int i = 0; i < nums.length; i++){
//             if(i > k) set.remove(nums[i-k-1]);
//             if(!set.add(nums[i])) return true;
//         }
//         return false;    
//     }
// }