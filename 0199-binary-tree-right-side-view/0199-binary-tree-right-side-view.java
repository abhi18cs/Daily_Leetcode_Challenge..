//Approach-1 Using DFS(RECURSIVE) 
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         ArrayList<Integer> ans=new ArrayList<>();
//         helper(root,ans,0);
//         return ans;
        
//     }
//     public void helper(TreeNode root,List<Integer> list,int depth){
//         if(root!=null){
//             if(depth==list.size()){
//                 list.add(root.val);
//             }
//             helper(root.right,list,depth+1);
//             helper(root.left,list,depth+1);
//         }
//     }
// }

//Approach-2 BFS(QUEUE/ITERATIVE)
class Solution{
    public List<Integer> rightSideView(TreeNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            TreeNode node=null;
            while(size>0){
                node=queue.poll();
                if(node.left!=null){
                    //add in the queue
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    //add in the queue
                    queue.offer(node.right);
                }
                size--;
            }
            ans.add(node.val);
        }
        return ans;
    }
}