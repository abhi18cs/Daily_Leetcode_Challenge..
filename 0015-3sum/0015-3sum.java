//Approach-1 brute force using 3 loops tc=O(n3)sc=O(3*k)

//Approach-2 using hashing tc=O(n2*logm)sc=O(m)+O(n)
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> resultSet = new HashSet();
//         Arrays.sort(nums);
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++) map.put(nums[i], i);

//         for(int i = 0; i < nums.length - 2 && nums[i] <= 0;){
//             for (int j = i + 1; j < nums.length && nums[i] + nums[j] <= 0;) {
//                 int value = 0 - nums[i] - nums[j];
//                 //if (value < 0) break;
//                 if (value < 0) return new ArrayList<>(resultSet);
//                 if (value < nums[j]) break;
//                 if (map.containsKey(value) && map.get(value) > j)
//                     resultSet.add(Arrays.asList(nums[i], nums[j], value));
//                 j++;
//                 while(j < nums.length && nums[j] == nums[j - 1]) j++;
//             }
//             i++;
//             while(i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
//         }
//         return new ArrayList<>(resultSet) ;
//     }
// }

// //Approach-3 optimized approach using Two pointers Tc=O(N * LogN + N * N) Sc=O(N + LogN)[auxiallry]
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//O(nlogn)
        int n=nums.length;
        List<List<Integer>> result=new LinkedList<>();
        for(int i=0;i<n-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int lo=i+1,hi=n-1,sum=0-nums[i];
                //2pointers
                while(lo<hi){
                    if(nums[lo]+nums[hi]==sum){
                        result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                        lo++;hi--;
                    }
                    else if(nums[lo]+nums[hi]<sum) lo++;
                    else hi--;
                }
            }
        }
            return result;
    }
}