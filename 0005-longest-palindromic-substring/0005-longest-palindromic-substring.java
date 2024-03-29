class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        for(int m=0;m<s.length();m++)
        {
            int i=m;
            int j=m;
            //for odd length
            while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j))
            {
            
                if(j-i+1>ans.length())
                {
                    ans=s.substring(i,j+1);
                }
                j++;
                i--;
            }
            
            i=m;
            j=m+1;
            // for even length
             while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j))
            {
            
                if(j-i+1>ans.length())
                {
                    ans=s.substring(i,j+1);
                }
                j++;
                i--;
            }
            
            
        }
        return ans;
    }
 
}