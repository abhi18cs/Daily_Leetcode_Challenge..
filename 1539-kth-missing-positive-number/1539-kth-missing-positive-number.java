//Appraoch Using Binary Search tcO=(logn) sc=O(1)
class Solution {
    public int findKthPositive(int[] arr, int k) {
      int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
                if(arr[m]-(m+1)>=k) h=m;
                else l=m+1;
        }
        return l+k;
    }
}

 
    