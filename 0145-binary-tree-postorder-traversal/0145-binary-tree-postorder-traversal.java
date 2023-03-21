//Approach-1 Using Recursion Tc=O(n) Sc=O()
// class Solution {
//     ArrayList<Integer> list=new ArrayList<>();
//     public List<Integer> postorderTraversal(TreeNode root) {
//         if(root!=null){
//             postorderTraversal(root.left);
//             postorderTraversal(root.right);
//             list.add(root.val);
//         }
//         return list;
//     }
// }

//Approach-2 Using Iteratively Tc=O(n) Sc=O()
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.addFirst(p.val);  // Reverse the process of preorder
            p = p.right;             // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder
        }
    }
    return result;
    }
}