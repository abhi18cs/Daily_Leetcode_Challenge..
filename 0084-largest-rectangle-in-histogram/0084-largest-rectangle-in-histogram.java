//Approach-1 The approach is to find the right smaller and left smaller element and find the largest Rectangle area in Histogram.
//Tc=O(n2) Sc=O(1)
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n=heights.length;
//         int maxArea = 0;
//         for (int i = 0; i < n; i++) {
//             int minHeight = Integer.MAX_VALUE;
//             for (int j = i; j < n; j++) {
//                 minHeight = Math.min(minHeight, heights[j]);
//                 maxArea = Math.max(maxArea, minHeight * (j - i + 1));
//             }
//         }
//         return maxArea;
//     }
// }


//Approach-2 Using next greater element and the next smaller element.
//Tc=O(n) Sc=O(3n) where 3 is for the stack, left small array and a right small array
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         Stack < Integer > st = new Stack < > ();
//         int leftSmall[] = new int[n];
//         int rightSmall[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
//                 st.pop();
//             }

//             if (st.isEmpty()) leftSmall[i] = 0;
//             else leftSmall[i] = st.peek() + 1;
//             st.push(i);
//         }

//         // clear the stack to be re-used
//         while (!st.isEmpty()) st.pop();
//         for (int i = n - 1; i >= 0; i--) {
//             while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
//                 st.pop();
//             }

//             if (st.isEmpty()) rightSmall[i] = n - 1;
//             else rightSmall[i] = st.peek() - 1;

//             st.push(i);
//         }

//         int maxA = 0;
//         for (int i = 0; i < n; i++) {
//             maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
//         }
//         return maxA;

//     }
// }


//Approach-3 This approach is a single pass approach instead of a two-pass approach. When we traverse the array by finding the next greater element, we found that some elements were inserted into the stack which signifies that after them the smallest element is themselves So we can find the area of the rectangle by using 
//arr[i] * (right smaller – left smaller -1 ).

//Tc=O(n)+O(n) Sc=O(n)
    class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack < Integer > st = new Stack < > ();
        int maxA = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
}