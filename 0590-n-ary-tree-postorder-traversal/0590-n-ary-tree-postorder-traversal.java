class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ans=new LinkedList<>();
        return helper(root,ans);  
    }

    public List<Integer> helper(Node root,LinkedList ans){
        if(root==null){
            return ans;
        }

        for(Node i : root.children){
            helper(i,ans);
        }
        
        ans.add(root.val);
        return ans;
    }
    
}