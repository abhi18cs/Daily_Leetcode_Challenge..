class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int high=Integer.MIN_VALUE;
               int low=1;
               for(int i:piles){
                   high=Math.max(high,i);
                 //  low=Math.min(low,i);
               }
               
               while(low<=high){
                  int mid=low+(high-low)/2;
                   long sum=0;
                   for(int i=0;i<piles.length;i++){
                     if(piles[i]>=mid && piles[i]%mid==0)
                       sum+=piles[i]/mid;
                       else sum+= ( (piles[i]/mid)+1);
                   }
                //   System.out.println(sum);
                   if(sum>h){
                       low=mid+1;
                   }
                   else  high=mid-1;
               }
               return low;
    }
}