class Solution {
    static char ZERO = '0';
    int ans;
    char[] a;

    public int maxScore(String s) {
        ans = 0;
        a = s.toCharArray();
        getRight(0, 0, a.length - 1);
        return ans;
    }

    private int getRight(int po, int l, int n) {
        if (po >= n) {
            return a[n] == ZERO ? 0 : 1;
        }
        if (a[po] == ZERO) {
            int r = getRight(po + 1, l + 1, n);
            ans = Math.max(ans, l + 1 + r);
            return r;
        } else {
            int r = getRight(po + 1, l, n);
            ans = Math.max(ans, l + r);
            return r + 1;
        }
    }
}