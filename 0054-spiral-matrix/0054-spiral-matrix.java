class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix.length==0) return res;
        int rowBegin=0,rowEnd=matrix.length-1;
        int colBegin=0,colEnd=matrix[0].length-1;
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            //TraverseRight
            for(int j=colBegin;j<=colEnd;j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            //TraverseDown
            for(int j=rowBegin;j<=rowEnd;j++){
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            if(rowBegin<=rowEnd){
                //TraverseLeft
                for(int j=colEnd;j>=colBegin;j--){
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
        
        if(colBegin<=colEnd){
                //TraverseLeft
                for(int j=rowEnd;j>=rowBegin;j--){
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
    
    return res;
        
    }
}
