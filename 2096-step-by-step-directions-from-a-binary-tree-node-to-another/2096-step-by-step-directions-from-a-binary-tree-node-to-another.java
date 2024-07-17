class Solution {
    public String getDirections(TreeNode root, int st, int ed) {
        TreeNode lca = lca(root, st, ed);

        StringBuilder stPath = new StringBuilder();
        StringBuilder edPath = new StringBuilder();

        findPath(lca, st, stPath);
        findPath(lca, ed, edPath);

        int i = 0;
        int j = edPath.length() -1;

        StringBuilder res = new StringBuilder();

        while(i < stPath.length()){
            res.append("U");
            i++;
        }

        while(j >= 0){
            res.append(edPath.charAt(j));
            j--;
        }

        return new String(res);
    }

    public TreeNode lca(TreeNode root, int st, int ed){
        if(root == null || root.val == st || root.val == ed) return root;

        TreeNode left = lca(root.left, st, ed);
        TreeNode right = lca(root.right, st, ed);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }

    public Boolean findPath(TreeNode root, int val, StringBuilder sb){
        if(root == null) return false;

        if(root.val == val) return true;

        if(findPath(root.left, val, sb)){
            sb.append("L");
            return true;
        }

        if(findPath(root.right, val, sb)){
            sb.append("R");
            return true;
        }

        return false;
    }
}