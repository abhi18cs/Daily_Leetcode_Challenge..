class Solution {
    public int maxSatisfied(int[] c, int[] g, int minutes) {
      int n = c.length;

        int totalSum = 0; //total number of customers entering (irrespective of owner being grumpy)
        int grumpySum = 0; //number of customers being unsatisfied because of owners grumpy behavior

        for(int i=0;i<n;i++){
            totalSum+=c[i];
            grumpySum+=(c[i]*g[i]);
        }

        int windowSum = 0; //number of customers being dissatisfied because of owners grumpy behavior in "minutes" time
        for(int i=0;i<minutes;i++){
            windowSum+=(c[i]*g[i]);
        }

        int maxWindowSum = windowSum; //maximum no. of customers dissatifies in that window of "minutes" range
        for(int i=minutes;i<n;i++){
            windowSum += c[i]*g[i];
            windowSum-=(c[i-minutes]*g[i-minutes]);
            maxWindowSum = Math.max(maxWindowSum,windowSum);
        }
        
        return totalSum-grumpySum+maxWindowSum;  
    }
}