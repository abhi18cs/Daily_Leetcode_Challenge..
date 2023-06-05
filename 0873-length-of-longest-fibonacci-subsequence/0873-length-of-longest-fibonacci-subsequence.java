class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(A[i], i);
            for (int j = i; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        for (int j = 2; j < n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int prev = A[j] - A[i];
                if (prev >= A[i]) {
                    break;
                }
                if (!pos.containsKey(prev)) {
                    continue;
                }
                dp[i][j] = dp[pos.get(prev)][i] + 1;
            }
        }
        int result = 0;
        for (int j = 2; j < n; j++) {
            for (int i = 1; i < n - 1; i++) {
                if (dp[i][j] > 2) {
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}