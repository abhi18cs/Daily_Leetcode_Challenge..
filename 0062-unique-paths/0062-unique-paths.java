/*This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.

For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-

D R R R D R R R

We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-

Total permutations = (m+n)! / (m! * n!)

Following is my code doing the same :-
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        // Check if either dimension is 1, return 1 as there is only one possible path
        if (m == 1 || n == 1)
            return 1;

        // Decrement m and n to convert dimensions into number of edges
        m--;
        n--;

        // Swap m and n if m is smaller, so that m represents the larger number
        if (m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }

        // Initialize variables
        long res = 1;
        int j = 1;

        // Calculate the number of unique paths
        for (int i = m + 1; i <= m + n; i++, j++) {
            res *= i;  // Multiply res by i
            res /= j;  // Divide res by j
        }

        // Return the result casted to an integer
        return (int) res;
    }
}

