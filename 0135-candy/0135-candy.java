public class Solution {
    public int candy(int[] A){
        int []ans = new int[A.length];
        Arrays.fill(ans,1);
        for(int i=1; i<A.length; i++){
            if(A[i]>A[i-1]){
                while(ans[i]<=ans[i-1])
                  ans[i]++;
            }
        }
        for(int i=A.length-2; i>=0; i--){
            if(A[i]>A[i+1]){
                while(ans[i]<=ans[i+1])
                  ans[i]++;
            }
        }
        int sum = 0;
        for(int val:ans){
            sum+=val;
        }
        return sum;
    }
}

