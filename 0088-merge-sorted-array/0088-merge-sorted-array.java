//Tc=O(nlogn) Sc=O(n) Using 2 pointers
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m + n - 1; // Pointer for the merged array

    // Start merging from the end of both arrays
    int p1 = m - 1; // Pointer for nums1
    int p2 = n - 1; // Pointer for nums2

    while (p1 >= 0 && p2 >= 0) {
        if (nums1[p1] > nums2[p2]) {
            nums1[i] = nums1[p1];
            p1--;
        } else {
            nums1[i] = nums2[p2];
            p2--;
        }
        i--;
    }

    // If there are remaining elements in nums2, add them to nums1
    while (p2 >= 0) {
        nums1[i] = nums2[p2];
        p2--;
        i--;
    }
}
}


