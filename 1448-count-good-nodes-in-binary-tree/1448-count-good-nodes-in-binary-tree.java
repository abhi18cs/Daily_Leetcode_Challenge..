class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        count(root,root.val);
        return count;
    }
    public void count(TreeNode root,int max){
        if(root==null) return ;
        if(root.val>=max) 
            count++;
            max=Math.max(max,root.val);
        count(root.left,max);
        count(root.right,max);
    }
}