//Approach-1 Using Recursion Tc=O(n) Sc=O()
// class Solution {
//     ArrayList<Integer> list=new ArrayList<>();
//     public List<Integer> preorderTraversal(TreeNode root) {
//         if(root==null) return list;
//         list.add(root.val);
//         preorderTraversal(root.left);
//         preorderTraversal(root.right);
//         return list;
//     }
// }

//Approach-2 Using Iteratively Tc=O(n) Sc=O()
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.add(p.val);  // Add before going to children
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            p = node.right;   
        }
    }
    return result;
    }
}