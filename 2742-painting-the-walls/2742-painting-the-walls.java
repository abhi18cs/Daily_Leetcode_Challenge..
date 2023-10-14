class Solution {
    int[] cost, time;
    int n;
    int[][] memo;
    public int paintWalls(int[] cost, int[] time) {
        this.n = cost.length;
        this.cost = cost;
        this.time = time;
        memo = new int[n][(n + 1) / 2 + 1000];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        return dfs(0, 0, n);
    }

    private int dfs(int index, int currTime, int remain) {
        if (currTime >= remain) return 0;
        if (index == n) return currTime < 0 ? Integer.MAX_VALUE / 2 : 0;
        if (memo[index][currTime + 500] != -1)
            return memo[index][currTime + 500];
        int paid = cost[index] + dfs(index + 1, currTime + time[index], n - 1);
        int free = dfs(index + 1, currTime - 1, n - 1);
        memo[index][currTime + 500] = Math.min(paid, free);
        return memo[index][currTime + 500];
    }
}