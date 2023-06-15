//Tc=O(m+n) Sc=O(1) Using 2 pointers
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1; // Pointer for the merged array

        // Start merging from the end of both arrays
        int p1 = m - 1; // Pointer for nums1
        int p2 = n - 1; // Pointer for nums2

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1]; // Place nums1[p1] in the merged array
                p1--; // Move p1 to the previous element in nums1
            } else {
                nums1[i] = nums2[p2]; // Place nums2[p2] in the merged array
                p2--; // Move p2 to the previous element in nums2
            }
            i--; // Move to the previous position in the merged array
        }

        // If there are remaining elements in nums2, add them to nums1
        while (p2 >= 0) {
            nums1[i] = nums2[p2]; // Place nums2[p2] in the merged array
            p2--; // Move p2 to the previous element in nums2
            i--; // Move to the previous position in the merged array
        }
    }

}


