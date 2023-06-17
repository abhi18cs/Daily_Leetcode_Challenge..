//Approach-1 Brute force Tc=O(n^4) Sc=O(1)

//Approach-2 Better Approach Using HashSet Tc=O(n3*logm) Sc=O(1)
class Solution{
    public List<List<Integer>> fourSum(int[] nums,int target){
        int n = nums.length; // size of the array
        Set<List<Integer>> st = new HashSet<>();
        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // taking bigger data type
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    // put the kth element into the hashset:
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}

//Approach-2 USing 2 Pointers Tc=O(n^3) Sc=O(1)
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         int n = nums.length;
//         Arrays.sort(nums);
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 long target2 = (long) target - (long) nums[i] - (long) nums[j];
//                 int lo = j + 1, hi = n - 1;
//                 while (lo < hi) {
//                     int twoSum = nums[lo] + nums[hi];
//                     if (twoSum < target2) lo++;
//                     else if (twoSum > target2) hi--;
//                     else {
//                         List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]);
//                         ans.add(quad);
//                         while (lo < hi && nums[lo] == quad.get(2)) lo++;
//                         while (lo < hi && nums[hi] == quad.get(3)) hi--;
//                     }
//                 }
//             while (j + 1 < n && nums[j] == nums[j + 1]) j++;
//             }
//             while (i + 1 < n && nums[i] == nums[i + 1]) i++;
//         }
//         return ans;
//     }
// }
