// Approach-1 Brute force Tc=O(n^2) Sc=O(1)
// class Solution {
//     public static int maxArea(int[] height) {
//         int len = height.length;
//         int max = 0;
//         for (int i = 0; i < len - 1; i++) {
//             for (int j = i + 1; j < len; j++) {
//                 int area = Math.min(height[i], height[j]) * (j - i);
//                 max = Math.max(max, area);
//             }
//         }
//         return max;
//     }  
// }

// Approach-2 Two Pointers Tc=O(n) Sc=O(1)
class Solution{
    public static int maxArea(int[] height){
       int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            // Move the shorter lines each time
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            int area=Math.min(height[left], height[right]) * (right - left);
            // update the max area
            max = Math.max(max,area);
        }

        return max; 
    }
}