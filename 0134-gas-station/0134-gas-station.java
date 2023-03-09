//https://leetcode.com/problems/gas-station/solutions/1705957/java-a-very-detailed-explanation-intuition-behind-logic-brute-force-to-optimised/?orderBy=most_votes&languageTags=java

//TC=O(n) sc=O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0,result=0,sum=0;
        for(int i=0;i<gas.length;i++){
            result=result+gas[i]-cost[i];
            if(result<0){
                start=i+1;
                sum=sum+result;
                result=0;
            }
        }
        
        return sum+result >= 0 ? start : -1;
    }
}