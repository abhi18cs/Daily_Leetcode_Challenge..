//Approach-1 TC=O(nlogn) SC=O(1)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//     Arrays.sort(nums);
//     return nums[nums.length-k];
//     }
// }

//Approach-2 Using Heap TC=O(nlogk) SC=O(K)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//     PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1);
//     for(int el : nums) {
//         pq.add(el);
//         if (pq.size() > k) {
//             pq.poll();
//         }
//     }
//     return pq.poll();
//     }      
// }

//Approach-3 Using QuickSelect TC=O(n) SC=O(1) where n is the size of the array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = end;
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (nums[left] > nums[pivot]) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        swap(nums, left, pivot);
        
        int rank = nums.length - left;
        if (rank == k) return nums[left];
        if (rank > k) return quickSelect(nums, left + 1, end, k);
        return quickSelect(nums, start, left - 1, k);
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}