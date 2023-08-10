class Solution {
    public int reverse(int x) {
        int y=0; //to store the reverse num;
            while(x!=0){
                int rem=x%10; //for the last digit
                int newY=y*10+rem; //for append the last digit
                if((newY-rem)/10!=y) return 0;
                y=newY;
                x=x/10; //discard the last value of x 
            }
        return y;
    }
    
}