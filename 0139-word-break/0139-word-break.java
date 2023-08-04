class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<String>(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++)
                if(!dp[i]) {
                    dp[i] = dp[j] && dictionary.contains(s.substring(j, i));
                }
        }
        return dp[s.length()];
    }
}