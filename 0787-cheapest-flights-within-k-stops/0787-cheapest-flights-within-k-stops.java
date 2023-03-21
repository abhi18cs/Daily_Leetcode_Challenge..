import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        long[] res = new long[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        int i = 0;
        res[src] = 0;
        while (i < n && (++i <= k+1)) {
            long[] vec = res.clone();
            for (int[] it : flights) {
                if (vec[it[1]] > res[it[0]] + it[2]) {
                    vec[it[1]] = res[it[0]] + it[2];
                }
            }
            res = vec;
        }
        if (res[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return (int) res[dst];
    }
}
