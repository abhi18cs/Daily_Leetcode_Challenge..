class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res =new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++){
            //for 1st element
            res.add(1);
            for(int j=i-1;j>0;j--){
                res.set(j,res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}


    		