class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1; // Start with 1 because we're considering [1, n]
        k--; // Decrement k because we start at the first element (1)

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                // Move to the next sibling
                current++;
                k -= steps;
            } else {
                // Move down to the next level
                current *= 10;
                k--;
            }
        }

        return current;
    }
    // Count the steps between two prefixes
    private long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}