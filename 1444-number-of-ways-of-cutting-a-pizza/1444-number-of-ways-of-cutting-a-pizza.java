class Solution {
    static int[][] pre;
    static long MOD=(long)(1e9+7);
    public int ways(String[] pizza, int k) {

        int m= pizza.length;
        int n=pizza[0].length();
        int[][] arr = new int[m][n];

        for(int i=0;i<m;++i)
        {
            String s=pizza[i];
            for(int j=0;j<n;++j)
            {
                if(s.charAt(j)=='A')
                    arr[i][j]=1;
                else
                    arr[i][j]=0;
            }
        }
        pre=new int[m][n];
        preprocess(arr);

        // debugIntInt(pre);
        dp=new long[m+1][n+1][k+1];
        for(int i=0;i<=m;++i)
        {
            for(int j=0;j<=n;++j)
            {
                Arrays.fill(dp[i][j], -1);
            }
        }
        long ans=rec(arr, k, 0, 0);
        return (int)ans;
    }
    static long[][][] dp;
    public long rec(int[][] arr, int k, int I, int J)
    {
        if(k==1)
        {
            if(pre[I][J] > 0)
                return 1;
            else
                return 0;
        }
        int m=arr.length, n=arr[0].length;
        if(I<m && J<n && dp[I][J][k] != -1)
            return dp[I][J][k];
        int totalApples = pre[I][J];

        long ans=0;
        for(int i=I+1;i<m;++i)
        {
            int remainingAppleSum = pre[i][J];
            boolean isValidCut = false;
            if(remainingAppleSum < totalApples)
                isValidCut = true;
                
            if(isValidCut)
            {
                ans=add(ans, rec(arr, k-1, i, J));
            }
        }
        for(int j=J+1;j<n;++j)
        {
            int remainingAppleSum = pre[I][j];
            boolean isValidCut = false;
            if(remainingAppleSum < totalApples)
                isValidCut = true;
                
            if(isValidCut)
            {
                ans=add(ans, rec(arr, k-1, I, j));
            }
        }
        return dp[I][J][k] = ans;
    }
    public long add(long x, long y)
    {
        return (x+y)%MOD;
    }
    public void preprocess(int[][] arr)
    {
        int m=arr.length, n=arr[0].length;

        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                int sum1=0, sum2=0, sum3=0;
                if(i+1<m && j+1<n)
                    sum1=pre[i+1][j+1];
                if(j+1<n)
                    sum2=pre[i][j+1];
                if(i+1<m)
                    sum3=pre[i+1][j];

                pre[i][j] = sum1+(sum3-sum1) + (sum2-sum1) + arr[i][j];
            }
        }

    }
    static void debugIntInt(int[][] arr)
    {
        for(int i=0;i<arr.length;++i)
        {
            for(int j=0;j<arr[0].length;++j)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }
}