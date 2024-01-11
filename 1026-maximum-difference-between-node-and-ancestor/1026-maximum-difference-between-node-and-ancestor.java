// Find the minimum and maximum on each root to leaf path in preorder.
// At the ending (null nodes after leaf) return the difference b/w max and min.
// In postorder, compare the max differences of all paths.

class Solution {
    
    public int solve(TreeNode root, int min, int max) {
        
        if (root == null) {
            return max-min;
        }
        
        if (root.val < min) min = root.val;
        if (root.val > max) max = root.val;
        
        return Math.max(solve(root.left, min, max), solve(root.right, min, max));
    }
    
    public int maxAncestorDiff(TreeNode root) {
        
        return solve(root, root.val, root.val);
    }
}