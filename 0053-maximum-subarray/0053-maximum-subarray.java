
//Brute force 3 loops 2 for traversing and 3 loop for the calculation Tc=O(n3) Sc=O(1)
//Better Approach  Tc=O(n2) Sc=O(1)
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxi = Integer.MIN_VALUE; // maximum sum

//         for (int i = 0; i < n; i++) {
//             int sum = 0;
//             for (int j = i; j < n; j++) {
//                 // current subarray = arr[i.....j]

//                 //add the current element arr[j]
//                 // to the sum i.e. sum of arr[i...j-1]
//                 sum += arr[j];

//                 maxi = Math.max(maxi, sum); // getting the maximum
//             }
//         }

//         return maxi;
//     }
// }

// Best/Optimal Approach TC=O(N) SC=O(1) Kadanes Algo but this will not(doubt) work for negative nums
class Solution {
    public int maxSubArray(int[] nums) {
       if(nums.length==1) return nums[0];
        int n=nums.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            max=Math.max(sum,max);
            if(sum<0) sum=0;
        }
        return max;
    }
}