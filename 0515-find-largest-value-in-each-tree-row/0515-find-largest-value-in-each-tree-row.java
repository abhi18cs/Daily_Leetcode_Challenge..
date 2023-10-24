class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxLevelVal = new ArrayList<>();
        if(root == null)return maxLevelVal;
        Deque<TreeNode> levelQueue = new ArrayDeque<>();
        levelQueue.offerLast(root);
        while(!levelQueue.isEmpty()){
            int sz = levelQueue.size();
            int maxValNode = Integer.MIN_VALUE;
            while(sz-->0){
                TreeNode currNode = levelQueue.pollFirst();
                maxValNode = Math.max(currNode.val, maxValNode);
                if(currNode.left != null){
                    levelQueue.offerLast(currNode.left);
                }
                if(currNode.right != null){
                    levelQueue.offerLast(currNode.right);
                }
            }
            maxLevelVal.add(maxValNode);
        }
        return maxLevelVal;
    }
}