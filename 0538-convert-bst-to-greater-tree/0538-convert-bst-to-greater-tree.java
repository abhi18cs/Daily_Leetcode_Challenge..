//Approach-1 Using Recursion Tc=O(n) Sc=O(1) Same as Question==https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }
}