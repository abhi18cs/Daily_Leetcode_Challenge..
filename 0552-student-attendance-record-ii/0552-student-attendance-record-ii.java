class Solution {
    int m = 1000000007;
    public int checkRecord(int n) {
        long[] dp =  helper(n);
        long records = 0;
        for (long r : dp) {
            records += r;
        }
        return (int) (records % m);
    }

    public long[] helper(int n) {
        // the number of sequences that start with two L is equal to helper(n - 3), then add  a LLP, or LLA to the beginning
        // the number of sequences that start with a single L is equal to helper(n - 2), then add a LP, or LA to the beginning
        // the number of sequences that don't start with a L is equal to helper(n - 1) and then add an P or an A to the beginning
        if (n < 8) {
            long[] dp = new long[]{1, 1, 0, 1, 0, 0};
            while (-- n > 0) {
                step(dp);
            }
            return dp;
        }
        long[] second = helper(n / 2 - 3);
        long[] first = second.clone();
        step(first);
        step(first);
        step(first);
        long[] dp = new long[6];
        for (int i = 0 ; i < 3 ; i ++) {
            long t = 0, s = 0;
            for (int j = 0 ; j <= i ; j ++) {
                t += first[j];
                s += first[j + 3];
            }
            t %= m;
            // the ...P case: first... (L)P second
            for (int j = 0 ; j < 6 ; j ++) {
                dp[j] += t * second[j];
                dp[j] %= m;
            }
            // the ...A case: first... (L)A second
            for (int j = 3 ; j < 6 ; j ++) {
                dp[j] += t * second[j - 3];
                dp[j] %= m;
            }
            // case where A is in the first half
            for (int j = 3 ; j < 6 ; j ++) {
                dp[j] += s * second[j - 3];
                dp[j] %= m;
            }
            step(second);
        }
        if (n % 2 != 0) {
            step(dp);
        }
        return dp;
    }

    public void step(long[] dp) {
        long t0 = (dp[0] + dp[1] + dp[2]) % m;
        long t3 = (t0 + dp[3] + dp[4] + dp[5]) % m;
        dp[2] = dp[1];
        dp[1] = dp[0];
        dp[5] = dp[4];
        dp[4] = dp[3];
        dp[3] = t3;
        dp[0] = t0;
    }
}