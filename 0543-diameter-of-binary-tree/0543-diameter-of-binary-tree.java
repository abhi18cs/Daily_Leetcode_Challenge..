class Solution {
    static int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
       if(root==null) return 0;
        int dl=diameterOfBinaryTree(root.left);
        int dr=diameterOfBinaryTree(root.right);
        int curr=height(root.left)+height(root.right);
        return Math.max(curr,Math.max(dl,dr));
    }
    
}