//Brute force tc=O(n^2) SC=O(1)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int max=0;
//         for(int i=0;i<prices.length-1;i++){
//             for(int j=i+1;j<prices.length;j++){
//                 max=Math.max(max,prices[j]-prices[i]);
//             }
//         }
//         return max;
//     }
// }

//optimized approach tc=O(n) SC=O(1) Sliding window approach
// class Solution {
//     public int maxProfit(int[] prices) {
//         int lsf = Integer.MAX_VALUE; // least so far
//         int op = 0; // overall profit
//         int pist = 0; // profit if sold today
//         for(int i = 0; i < prices.length; i++){
// // if we found new buy value which is more smaller then previous one
//             if(prices[i] < lsf){ 
//                 lsf = prices[i]; // update our least so far
//             }
// // calculating profit if sold today by, Buy - sell            
//             pist = prices[i] - lsf; 
// // if pist is more then our previous overall profit
//             if(op < pist){ 
//                 op = pist; // update overall profit
//             }
//         }
//         return op; // return op 
//     }
// }
//Approach-3 Using DP(remambering the past) tc=O(n) sc=O(1)
class Solution {
     public int maxProfit(int[] prices) {
         int min=prices[0];
         int maxProfit=0;
         for(int i=1;i<prices.length;i++){
             int cost =prices[i]-min;
             maxProfit=Math.max(cost,maxProfit);
             min=Math.min(min,prices[i]);
         }
         return maxProfit;
     }
}