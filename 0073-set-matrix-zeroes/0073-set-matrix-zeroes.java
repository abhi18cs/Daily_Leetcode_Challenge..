//https://leetcode.com/problems/set-matrix-zeroes/solutions/2525398/all-approaches-from-brute-force-to-optimal-with-easy-explanation/?orderBy=most_votes&languageTags=java

//Brute Force Tc=O((mn)*(m+n)) Sc=O(mn)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;//no of rows
        int n=matrix[0].length;// no of col
        int[] row = new int[m];//new matrix of same length
        int[] col = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=1;// traverse and check the ele is zero if it is then just                                       simply place 1 at that place
                  col[j]=1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==1||col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}