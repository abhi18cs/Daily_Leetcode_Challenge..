class Solution {
    Integer dp[][];

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.dp = new Integer[piles.size() + 1][k + 1];
        return solve(0, piles, k);
    }

    private int solve(int index, List<List<Integer>> p, int k) {
        if (index >= p.size()) return 0;
        int max = 0, sum = 0;
        if (dp[index][k] != null) return dp[index][k];
        //either dont take from that pile
        max = Math.max(max, solve(index + 1, p, k));
        for (int i = 0; i < p.get(index).size(); i++) {
            sum += p.get(index).get(i);
            //or take some certain prefix from that pile, if we can take that much elements.
            if (k - (i + 1) >= 0) max = Math.max(max, sum + solve(index + 1, p, k - (i + 1)));
        }
        return dp[index][k] = max; // return max
    }
}