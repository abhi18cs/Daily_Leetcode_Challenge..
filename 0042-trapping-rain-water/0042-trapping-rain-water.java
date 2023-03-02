class Solution {
    public int trap(int[] height) {
        int n=height.length;
        //for pfmax
        int max=height[0];
        int pfmax[]=new int[n];
        pfmax[0]=height[0];
        for(int i=1;i<n;i++){
            if(max<height[i]){
             max=height[i]; //update max
            }
        pfmax[i]=max;
        }
        //for sfmax
        max=height[n-1];
        int sfmax[]=new int[n];
        sfmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            if(max<height[i]){
                max=height[i];
            }
        sfmax[i]=max;
        }
        //rain water
        int ans=0;
        for(int i=0;i<n;i++){
            int lmax=pfmax[i];
            int rmax=sfmax[i];
            int hlevel=Math.min(lmax,rmax);
            int w=Math.max((hlevel-height[i]),0);
            ans+=w;
        }
        return ans;
    }
}
