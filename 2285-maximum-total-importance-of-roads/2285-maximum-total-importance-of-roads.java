class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n + 1];
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            degree[u]++;
            degree[v]++;
        }
        Arrays.sort(degree);
        // System.out.println(Arrays.toString(degree));
        long maxImportance = 0;
         for (long i = 1; i <= n; i++) {
             maxImportance += degree[(int)i]*i;
         }
        
        return maxImportance;
    }
}