//validaye BST
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root,long minval,long maxval){
        if(root==null) return true;
        if(root.val>=maxval || root.val<=minval) return false;
        return isValid(root.left,minval,root.val) && isValid(root.right,root.val,maxval);
    }
}

