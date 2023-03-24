public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result=0;
        while(n!=0){
            if((n&1)==1){
                result++;
            }
 //Then we shift the input Integer by one on the right, to check for the next bit.
        n>>>=1;
        }
       return result; 
    }
}
