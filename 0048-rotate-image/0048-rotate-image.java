class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        
        // Copy the rotated matrix back to the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }
}

// class Solution {
//     public void rotate(int[][] matrix) {
//         //in this que for clockwise we do column reverse and for anticlockwise row reverse now after reversing we do the transpose of the matrix
//         //1.Transpose of matrix
//         for(int r=0;r<matrix.length;r++){
//             for(int c=0;c<r;c++){
//                 int temp=matrix[r][c];
//                 matrix[r][c]=matrix[c][r];
//                 matrix[c][r]=temp;
//             }
//         }
            
        
//         //2.we here reverse the column bcoz it is c.w
//         int fc=0;  //firstcol
//         int lc=matrix[0].length-1;  //lastcol
//          while(fc<lc){
//              //now here we are swapping the first
//              for(int r=0;r<matrix.length;r++){
//                  int temp=matrix[r][fc];
//                  matrix[r][fc]=matrix[r][lc];
//                  matrix[r][lc]=temp;
//              }
//              fc++; lc--;
//          }
//     }
// }