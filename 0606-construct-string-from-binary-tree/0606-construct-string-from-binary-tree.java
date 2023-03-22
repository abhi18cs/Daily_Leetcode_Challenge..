class Solution {
    public String tree2str(TreeNode root) {
        //base case
        if(root==null) return "";
        String res=""; //for storing result
        //for left subtree
        if(root.left!=null)
            res+="("+ tree2str(root.left) +")";
        //when left==null & root.right!=null
        if(root.left==null && root.right!=null)
            res+="()";
        // for right subtree
        if(root.right!=null)
            res+="("+ tree2str(root.right) +")";
        return root.val+res;
        
    }
}