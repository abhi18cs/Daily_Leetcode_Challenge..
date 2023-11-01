class Solution {
    int curr = Integer.MIN_VALUE;
    int count = 0;
    int maxCount = 0;
    List<Integer> res = null;
    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        helper(root);

        if(maxCount < count) 
        {
            res = new ArrayList<>();
            res.add(curr);
            maxCount = count;
        } else if (maxCount == count) res.add(curr);

        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++) ans[i] = res.get(i);
        
        return ans;
    }
    void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);

        if(curr != root.val)
        {
            if(maxCount < count) 
            {
                res = new ArrayList<>();
                res.add(curr);
                maxCount = count;
            }
            else if (maxCount == count) res.add(curr);

            curr = root.val;
            count = 1;
            
        }
        else count++;

        helper(root.right);
    }
}