class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
         int max = arrays.get(0).get(arrays.get(0).size()-1);
         int res = 0;
         for(int i=1;i<arrays.size();i++){
            int x = arrays.get(i).get(0);
            int y = arrays.get(i).get(arrays.get(i).size()-1);
            res = Math.max(res, Math.max(Math.abs(min - y), Math.abs(max- x)));
            min = Math.min(x,min);
            max = Math.max(y,max);
         }
         return res;
    }
}