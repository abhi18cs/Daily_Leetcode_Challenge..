//https://leetcode.com/problems/set-matrix-zeroes/solutions/2525398/all-approaches-from-brute-force-to-optimal-with-easy-explanation/?orderBy=most_votes&languageTags=java

//Brute Force Tc=O((mn)*(m+n)) Sc=O(mn)
// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int m=matrix.length;//no of rows
//         int n=matrix[0].length;// no of col
//         int[] row = new int[m];//new matrix of same length
//         int[] col = new int[n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]==0){
//                     row[i]=1;// traverse and check the ele is zero if it is then just                                       simply place 1 at that place
//                   col[j]=1;
//                 }
//             }
//         }
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(row[i]==1||col[j]==1){
//                     matrix[i][j]=0;
//                 }
//             }
//         }
//     }
// }

//Better Approach Tc=O(mn), Sc=O(m+n)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;//no of rows
        int n=matrix[0].length;// no of col
        int[] rowsArray = new int[m];//we can use two separate arrays one for rows (rowsArray) and one for columns (colsArray) and initialize them to 1
        int[] colsArray = new int[n];
        Arrays.fill(rowsArray,1);
        Arrays.fill(colsArray,1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowsArray[i]=0;// while traversing the given matrix whenever we encounter 0 at (i,j), we will set rowsArray[i]=0 and colsArray[j]=0
                  colsArray[j]=0;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){//again iterate through the matrix and for any (i,j), if rowsArray[i] or colsArray[j] is 0 then update matrix[i][j] to 0.
                if(rowsArray[i]==0||colsArray[j]==0){
                    matrix[i][j]=0;
                }
            }
        }
    }
}