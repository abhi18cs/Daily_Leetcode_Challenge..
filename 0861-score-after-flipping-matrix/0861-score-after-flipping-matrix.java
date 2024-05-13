class Solution {
    public int matrixScore(int[][] ar) {
        int n = ar.length, m = ar[0].length;
        for (int i = 0; i < n; i++) {
            if (ar[i][0] == 0) {
                // flip the row which has 0 at 1st col of every row
                for (int j = 0; j < m; j++) {
                    ar[i][j] ^= 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int ones = 0, zero = 0;
            for (int j = 0; j < n; j++) {
                ones += (ar[j][i] & 1);
            }
            zero = n - ones;
            if (zero > ones) {
                for (int j = 0; j < n; j++) {
                    ar[j][i] ^= 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ar[i][m-j-1] == 1) {
                    ans += (1 << j);
                }
            }
        }
        return ans;
    }
}