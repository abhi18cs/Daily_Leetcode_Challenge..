class Solution {
    public int[] findArray(int[] pref) {
        int prev=0;
        for(int i=0;i<pref.length;i++) {
            int c=pref[i];
            pref[i]=prev^pref[i];
            prev=c;
        }
        return pref;
    }
}