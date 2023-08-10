class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int y=0;
        while(x>0){
            //extract the last digit
            int rem=x%10;
            //add the last digit
            y=y*10+rem;
            //shrinking x by discarding the last digit
            x=x/10;
            
        }
        if(temp==y) return true;
        else return false;
        
    }
}