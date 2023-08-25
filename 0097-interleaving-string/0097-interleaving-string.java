class Solution {
    /*To make String s3, length of s1 + s2 should be equal to s3, else return false;
    Now there are three possibilities
    1) char of s1 == char of s3, then go to next char of s1 and recursively find the solution
    2) char of s2 == char of s3, then go to next char of s2 and find solution
    3) both s1 and s2 have same character as s3, then increment index of both s1 and s2 and find the solution
    
    Since recursion gives TLE, we can Memoize the solution using 2D Boolean array, as there are two changing parameters 
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if( m+n != s3.length()) return false;
        return helper(0,0,s1,s2,s3,new Boolean[m+1][n+1]);
    }
    
    private boolean helper(int i, int j, String s1, String s2, String s3, Boolean[][] dp){
        if(i==s1.length() && j==s2.length()) return dp[i][j]=true;
        
        if(dp[i][j]!=null) return dp[i][j];
    
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            boolean ans = helper(i+1,j,s1,s2,s3,dp);
            dp[i][j] = ans;
            if(ans==true) return true;
        }
        
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            boolean ans = helper(i,j+1,s1,s2,s3,dp);
            dp[i][j] = ans;
            if(ans==true) return true;
        }
        
        return dp[i][j] = false;
    }
}