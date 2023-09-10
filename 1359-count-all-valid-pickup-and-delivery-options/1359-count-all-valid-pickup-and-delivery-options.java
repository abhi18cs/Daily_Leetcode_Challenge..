class Solution {
    public int countOrders(int n) {
     if(n==1) return 1;
        else if(n==2) return 6;
        
		
        int prev_ans = 6;  
        
        long mod = 1000000007;
        for(int i=3;i<=n;i++)
        {
            long k = (long) (i*2 -1);    // k = total number of places in n-1
            long each = (k*(k+1))/2;     //total possibilities in each case of n-1
            long total = each * (long)prev_ans;    //total possibilities for n 
            prev_ans = (int) (total%mod);
        }
        
        return prev_ans;
       
    }
}