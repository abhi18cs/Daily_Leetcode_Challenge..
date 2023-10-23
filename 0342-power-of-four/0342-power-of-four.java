// class Solution {
//     public boolean isPowerOfFour(int n) {
//         for(int x=0;x<=100;x++){
//             if(Math.pow(4,x)==n) return true;
//         }
//         return false;
//     }
// }
// class Solution {
//     public boolean isPowerOfFour(int n) {
        
//         if(n == 0) return false;
//         if(n == 1) return true;
        
//         if(n % 4 != 0) return false;
        
//         return isPowerOfFour(n/4);    
//     }
// }
class Solution{
    public boolean isPowerOfFour(int n){
        if(n>1){
            while(n%4==0){
                n=n/4;
            }
        }
        if(n==1) return true;
        return false;
    }
}