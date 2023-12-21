class Solution {
        
    public int maxWidthOfVerticalArea(int[][] points) {
        // Step 1: Extract x-coordinates
        int[] xCoordinates = new int[points.length];
        for (int i = 0; i < points.length; ++i) {
            xCoordinates[i] = points[i][0];
        }

        // Step 2: Sort x-coordinates
        Arrays.sort(xCoordinates);

        // Step 3: Calculate maximum width
        int max_width = 0;
        for (int i = 1; i < xCoordinates.length; ++i) {
            max_width = Math.max(max_width, xCoordinates[i] - xCoordinates[i - 1]);
        }

        return max_width;
    }
}