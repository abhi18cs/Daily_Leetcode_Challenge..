class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res=new ArrayList<>();
        if(n%2==0) return res;
        if(n==1){
            res.add(new TreeNode(0));
            return res;
        }
        for(int i=1;i<n;i=i+2){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(n-i-1);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(0);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}