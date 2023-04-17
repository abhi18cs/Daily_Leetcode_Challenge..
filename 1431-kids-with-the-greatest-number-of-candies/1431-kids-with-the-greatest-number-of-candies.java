class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length;
        ArrayList<Boolean> res=new ArrayList<Boolean>();
        int max_can=0,sum=0;
        for(int i=0;i<n;i++){
            if(max_can<candies[i])
               max_can=candies[i];
        }
        
        for(int i=0;i<n;i++){
            sum=candies[i]+extraCandies;
            if(sum>=max_can)
                res.add(i,true);
            else res.add(i,false);
        }
    return res;
    }
}