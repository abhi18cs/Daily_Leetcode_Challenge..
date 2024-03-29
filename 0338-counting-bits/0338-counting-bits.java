//Approach Tc=O(n) Sc=O(1w) https://leetcode.com/problems/counting-bits/discuss/1810303/Intuitive-explanation
class Solution {
    public int[] countBits(int n) {
        int res[]=new int[n+1];
        for(int i=1;i<=n;i++){
            if(i%2==0) res[i]=res[i>>1];
            else res[i]=res[i>>1]+1;
        }
        return res;
    }
}