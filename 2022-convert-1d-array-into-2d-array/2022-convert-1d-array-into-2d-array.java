// TC: O(n), SC: O(m * n)
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if((m*n)!=original.length){
            return new int[0][0];
        }
        int[][] res=new int[m][n];
        for(int i=0;i<original.length;i++){
            int rowIdx=i/n;
            int colIdx=i%n;
            res[rowIdx][colIdx]=original[i];
        }
        return res;
    }
}