class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int rightHeight=maxDepth(root.right);
        int leftHeight=maxDepth(root.left);
        return 1+Math.max(leftHeight,rightHeight);
    }
}