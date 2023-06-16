//Brute Force Using traversing the whole matrix Tc=O(m*n) Sc=O(1)
class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        //loop for row
        for(int i=0;i<matrix.length;i++){
            //loop for col 
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target) return true;
            }
        }
        return false;
    }
}
//Optimal Approach using Binary search tc=O(log(m*n)) sc=O(1)
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int col=matrix[0].length;
//         int row=matrix.length;
//         int l=0,h=(col*row)-1;
//         while(l<=h){
//             int mid=l+(h-l)/2;
//             if(matrix[mid/col][m%col]==target) return true;
//             if(matrix[mid/col][m%col]<target) l=m+1;
//             else h=m-1;
//         }
//         return false;
//     }
// }




















