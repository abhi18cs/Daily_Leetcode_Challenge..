//Approach-1 Using BFS
// class Solution {
//     public int findBottomLeftValue(TreeNode root) {
//         Queue<TreeNode> q=new ArrayDeque<>();
//         q.add(root);
//         int res=0;
//         while(q.size()>0)
//         {
//             int s=q.size();
//             for(int i=0;i<s;i++)
//             {
//                 TreeNode node=q.remove();
//                 if(i==0)
//                 {
//                    res=node.val ;
//                 }
//                 if(node.left!=null)
//                 {
//                     q.add(node.left);
//                 }
//                 if(node.right!=null)
//                 {
//                     q.add(node.right);
//                 }
//             }
//         }
//         return res;
        
//     }
// }

//Approach-2 Using DFS
    
    //to keep track of the level and the left most value by defining global variables
class Solution{
int level = 0 ; 
int leftMost ; 
    
    public int findBottomLeftValue(TreeNode root) {
        //edge case 
        if (root.left == null && root.right == null) return root.val ;  
        
        //using dfs in-order traversal by calling helper function 
        dfs(root, level) ;   
        
        //returning the leftMost value in the last row
        return leftMost ; 
    }
    
    private void dfs(TreeNode root, int level) {
       
        
        if (root != null) {
            
            //if the current level is greater then the global variable level, we update the leftMost
            if (level > this.level) { 
                this.level = level ; 
                leftMost = root.val ; 
            }
              
            //recursive call on the left with level + 1, since the child is on the level which is greater by 1 
            if (root.left != null)
            dfs(root.left, level + 1) ;
            
            //similarly, recursive call on the right child 
            if (root.right != null)
            dfs(root.right, level + 1) ; 
        }
    } 
}