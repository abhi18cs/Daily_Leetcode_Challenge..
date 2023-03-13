//Approach-1 Using Iterative Tc=O(sqrt(n)) Sc=O(1)
class Solution {
    public int arrangeCoins(int n) {
    int i=1;
        while(n>0){
            i++;
            n=n-i;
        }
        return i-1;
    }
}

// class Solution {
//     public int arrangeCoins(int n) {
//         long l=1,h=n;
//         while(l<=h){
//             long m=l+(h-l)/2;
//             long coinUsed=m*(m+1)/2;
//             if(coinUsed==n) return (int)m;
//             else if(coinUsed>n) h=m-1;
//             else l=m+1;
//         }
//         return (int)h;
//     }
// }