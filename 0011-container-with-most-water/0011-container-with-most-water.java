class Solution {
    public int maxArea(int[] height) {
    int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j])
                    i++;
            else j--; 
        }
            return maxArea;  
    }  
}
// TC - O(n)