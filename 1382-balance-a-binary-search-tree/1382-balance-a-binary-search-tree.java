/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void getInOrder(TreeNode root, ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        getInOrder(root.left,inorder);
        inorder.add(root.val);
        getInOrder(root.right,inorder);
    }
    public static TreeNode CreateBST(ArrayList<Integer> inorder, int left, int right) {
        if (left > right) return null;
        int m = (right + left) / 2;
        TreeNode root = new TreeNode(inorder.get(m));
        root.left = CreateBST(inorder, left, m - 1);
        root.right = CreateBST(inorder, m+ 1, right);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root,inorder);
        root = CreateBST(inorder,0,inorder.size()-1);
        return root;
        
    }
}