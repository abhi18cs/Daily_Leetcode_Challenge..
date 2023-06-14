// tc=O(n^2) sc=O(n^2)[OPTIMIZED SOL]
class Solution {
    public List<List<Integer>> generate(int numRows) {
       ArrayList<List<Integer>> ans=new ArrayList<>();
       for(int i=0;i<numRows;i++){
           ArrayList<Integer> temp=new ArrayList<>();
           int val=1;
           for(int j=0;j<=i;j++){
               temp.add(val);
               val=val*(i-j)/(j+1);
            }
            ans.add(temp);
        }
        return ans;
    }
}
