class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> li=new ArrayList<>();
        List<Integer> li1=new ArrayList<>();
        for(int[] i:matrix){
            int min=Integer.MAX_VALUE;
            for(int j:i){
                min=Math.min(min,j);
            }
            li.add(min);
        }
         for(int i=0;i<matrix[0].length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++){
                max=Math.max(max,matrix[j][i]);
            }
            if(li.contains(max))
            li1.add(max);
        }
        return li1;
    }
}