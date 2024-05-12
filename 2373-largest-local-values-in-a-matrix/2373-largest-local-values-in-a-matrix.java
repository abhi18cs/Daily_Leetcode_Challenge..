class Solution {
    public int[][] largestLocal(int[][] grid) {
        int max;
        int result[][] = new int[grid.length-2][grid.length-2];
        for(int i = 0; i < grid.length - 2; i++) {
            for(int j = 0; j < grid.length - 2; j++) {
                max = 0;
                for(int x = i; x < i + 3; x++) {
                    for(int y = j; y < j + 3; y++) {
                        max = Math.max(grid[x][y], max);
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}