//Approach-1 Using DFS(RECURSIVE) 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        helper(root,ans,0);
        return ans;
        
    }
    public void helper(TreeNode root,List<Integer> list,int depth){
        if(root!=null){
            if(depth==list.size()){
                list.add(root.val);
            }
            helper(root.right,list,depth+1);
            helper(root.left,list,depth+1);
        }
    }
}