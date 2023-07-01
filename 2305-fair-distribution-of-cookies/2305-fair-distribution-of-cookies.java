class Solution {
    int []c;
    int []kval;
    int k;
    private int solve(int ic) {
      if(ic == c.length) {
        int res = 0;
        for(int i:kval) res = Math.max(res, i);
        return res;
      }
      int res = Integer.MAX_VALUE;
      for(int i=0;i<k;i++) {
        kval[i]+=c[ic];
        res = Math.min(res, solve(ic+1));
        kval[i]-=c[ic];
      }
      return res;
    }
  
    public int distributeCookies(int[] cookies, int k) {
      this.kval = new int[k];
      this.k = k;
      this.c= cookies;
      return solve(0);
    }
}