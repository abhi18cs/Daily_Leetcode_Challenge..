//Approach-1 Using Recursion Tc=O(n) Sc=O(1)
class Solution {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
       
    if(root==null){
        return null;
    }
    bstToGst(root.right);
    int a =root.val;
    sum+=root.val;
    root.val=sum;
    bstToGst(root.left);
    return root;
    }
}