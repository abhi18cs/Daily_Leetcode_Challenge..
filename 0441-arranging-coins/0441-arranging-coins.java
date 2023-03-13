//Approach-1 Using Iterative Tc=O(sqrt(n)) Sc=O(1)
// class Solution {
//     public int arrangeCoins(int n) {
//         int i = 1; // which row we are on
// 		while(n > 0){ // checking to see if we have used all our coins
// 			i++; // increasing our row
// 			n = n-i; // adding coins to our row
// 		}
// 		return i-1; // we return our current row minus one because the last row is our completed row
//     }
// }

//Approach-2 Using BinarySearch Tc=O(log(n)) Sc=O(1)
class Solution {
    public int arrangeCoins(int n) {
        long l=1,h=n;
        while(l<=h){
            long m=l+(h-l)/2;
            long coinUsed=m*(m+1)/2;
            if(coinUsed==n) return (int)m;
            else if(coinUsed>n) h=m-1;
            else l=m+1;
        }
        return (int)h;
    }
}