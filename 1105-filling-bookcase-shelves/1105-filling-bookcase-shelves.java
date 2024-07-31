class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int dp[] = new int[books.length + 1];
        dp[0] = 0;

        for (int i = 1; i <= books.length; i++) {
            int min = dp[i - 1] + books[i - 1][1];
            int height = books[i - 1][1];
            int width = books[i - 1][0];
            int j = i - 2;
            while (j >= 0 && width + books[j][0] <= shelfWidth) {
                width += books[j][0];
                height = Math.max(height, books[j][1]);
                min = Math.min(min, height + dp[j]);
                --j;
            } 
            dp[i] = min;
        }
        return dp[books.length];
    }
}