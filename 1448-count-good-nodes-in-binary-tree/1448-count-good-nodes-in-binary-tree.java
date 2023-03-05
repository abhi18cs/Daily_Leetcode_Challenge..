class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        countGood(root, root.val);
        return count;
    }
    public void countGood(TreeNode root, int max) {
        if (root == null)
            return;
        if (root.val >= max)
            count ++;
        max = Math.max(root.val, max);
        countGood(root.left, max);
        countGood(root.right, max);
    }
}