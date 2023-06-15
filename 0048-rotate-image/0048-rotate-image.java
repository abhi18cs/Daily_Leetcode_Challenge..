//Brute Force Approach Tc=O(N*N) to linearly iterate and put it into some other matrix.
//Sc=O(N*N) to copy it into some other matrix.

// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         int[][] rotated = new int[n][n];//make a new matrix to copy the data
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 rotated[j][n - i - 1] = matrix[i][j];
//             }
//         }
//         // Copy the rotated matrix back to the original matrix
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 matrix[i][j] = rotated[i][j];
//             }
//         }
//     }
// }

//Optimal Approach Tc=O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other is for reversing the matrix. S=O(1).
class Solution {
    public void rotate(int[][] matrix) {
        //in this que for clockwise we do column reverse and for anticlockwise row reverse now after reversing we do the transpose of the matrix
        //1.Transpose of matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //2. Reversing the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
