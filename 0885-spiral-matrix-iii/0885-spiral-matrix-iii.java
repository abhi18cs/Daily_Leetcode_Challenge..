class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] matrix = new int[rows * cols][2];

        int i = 0;
        matrix[i++] = new int[] { rStart, cStart };
        int[] directions = new int[] { 0, 1, 0, -1, 0 };
        int len = 0;
        int diff = 0;
        while (i < rows * cols) {
            if (diff == 0 || diff == 2) {
                len++;
            }
            for (int k = 0; k < len; k++) {
                rStart += directions[diff];
                cStart += directions[diff + 1];

                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    matrix[i++] = new int[] { rStart, cStart };
                }
            }
            diff = (++diff) % 4;
        }

        return matrix;
    }
}