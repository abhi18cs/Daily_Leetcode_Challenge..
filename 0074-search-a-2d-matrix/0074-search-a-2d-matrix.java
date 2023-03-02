//Approach using Binary search tc=O(log(m*n)) sc=O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col=matrix[0].length;
        int row=matrix.length;
        int l=0,h=(col*row)-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(matrix[m/col][m%col]==target) return true;
            if(matrix[m/col][m%col]<target) l=m+1;
            else h=m-1;
        }
        return false;
    }
}




















