//Brute Force Using Sort Function Tc=O(nlogn) Sc=O(1)
//Better Approach Tc=O(N+N) Sc=O(1)
// class Solution {
//     public void sortColors(int[] nums) {
//         int n=nums.length;
//         int count0 = 0, count1 = 0, count2 = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) {count0++;}
//             if (nums[i] == 1) {count1++;}
//             if (nums[i] == 2) {count2++;}
//         }
//     for (int i = 0; i < count0; i++) nums[i] =0; // replacing 0's
//     for (int i = count0; i < count0 + count1; i++) nums[i] =1; // replacing 1's
//     for (int i = count0 + count1; i < n; i++) nums[i] =2; // replacing 2's
    
//     }
// }
// //Best/Optimal Approach Tc=O(N) Sc=O(1)
//This problem is a variation of the popular Dutch National flag algorithm. This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:
// arr[0….low-1] contains 0. [Extreme left part]
// arr[low….mid-1] contains 1.
// arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array

class Solution {
    public void sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if (nums[mid] == 0) {
                // swapping arr[low] and arr[mid]
                int temp = nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1) mid++;
            else{
                // swapping arr[mid] and arr[high]
                int temp = nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            
            }
        }
    }
}
        



















