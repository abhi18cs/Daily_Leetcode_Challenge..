class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root==null) return false;
        else if(isSameTree(root,subRoot)) return true;
        else return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSameTree(TreeNode root,TreeNode subRoot){
        if(root==null || subRoot==null)
            //return true;
        return root==null && subRoot==null; //doubt???
        else if (root.val==subRoot.val)
            return isSameTree(root.left,subRoot.left) &&  isSameTree(root.right,subRoot.right);
        else return false;
    }
}