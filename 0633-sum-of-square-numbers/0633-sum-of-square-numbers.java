// class Solution {
//     public boolean judgeSquareSum(int c) {
//         int root=(int)Math.sqrt(c);
//         long l=0;
//         long h=root;
//         while(l<=h){
//             long sum=(l*l)+(h*h);
//             if(sum==c) return true;
//             if(sum>c){
//                 h--;
//             }
//             else l++;
//         }
//         return false;
//     }
// }
class Solution {
    public boolean judgeSquareSum(int n) {
        
        long low = 0;
        long high = Math.min(n, Integer.MAX_VALUE/2);
        
        while(low<=high){
            long ls = low*low;
            long hs = high*high;
            
            long sum = ls+hs;
            if(sum==n){
                return true;
            }
            long mid = low+(high-low)/2;
            long ms = mid*mid;
            //if sum > n, then some how we have to decrese the high value
            if(sum>n){
                if(ms+ls>n){
                    high = mid-1;
                }else{
                    high--;
                }
            } // if sum < n, then some how we have to increse the low value 
            else{
                if(ms+hs<n){
                    low = mid+1;
                }else{
                    low++;
                }
            }
        }
        
        return false;
    }
}