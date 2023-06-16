class Solution{
    public int majorityElement(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //selected element is nums[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of nums[i]
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }
            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return nums[i];
        }
        return -1;
    }
}

//tc=O(nlogn) sc=O(1)
//By Sorting
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length/2];
//     }
// }

//tc=O(n) sc=O(n)
//By Hashing
// class Solution{
//     public int majorityElement(int[] nums){
//       HashMap<Integer,Integer> map=new HashMap<>();
//         int count=0;
//         for(int num :nums){
//             if(!map.containsKey(num)){
//                 map.put(num,1);
//             }
//             else map.put(num,map.get(num)+1);
        
//             if(map.get(num)>nums.length/2){
//                 count=num;
//                 break;
//             }
//         }
//         return count;
//     }
// }

//tc=O(n) sc=O(1)
//Moore Voting Algorithm
// class Solution{
//     public int majorityElement(int[] nums){
//         int count=0,res=0;
//         for(int num:nums){
//             if(count==0) res=num;
//             if(num!=res) count--;
//             else count++;
//         }
//         return res;    
//     }
// }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        