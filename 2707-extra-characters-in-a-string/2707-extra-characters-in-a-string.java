class Solution {
    int n;
    int[][] memo;
    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        memo = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], n);
        Set<String> words = new HashSet<>(Arrays.asList(dictionary));
        return dfs(0, s, words);
    }
    private int dfs(int index, String s, Set<String> words) {
        if (s.length() == 0) return 0;
        if (memo[index][s.length() - 1] != n) return memo[index][s.length() - 1];
        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            int curExtra = words.contains(str) ? 0 : i + 1;
            res = Math.min(res, curExtra + dfs(i + 1, s.substring(i + 1), words));
        }
        memo[index][s.length() - 1] = res;
        return res;
    }
}
