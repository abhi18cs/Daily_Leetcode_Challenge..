class Solution {
    String res = null;

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        getWords(root, sb);
        return res;
    }

    public void getWords(TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        char c = 'a';
        c += root.val;
        sb.append(c);
        if(root.left == null && root.right == null){
            String rev = sb.reverse().toString();
            if(res == null || rev.compareTo(res)<0)
                res = rev;
            sb.reverse();
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        getWords(root.left, sb);
        getWords(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}