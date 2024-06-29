class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Convert the edges[] array to a more usable format of 
        // the count of incoming edges to a node, and a list of 
        // outgoing edge "to" nodes.
        int[] inCount = new int[n];
        ArrayList<Integer>[] outList = new ArrayList[n];
        for (int i = 0; i < n; i++)
            outList[i] = new ArrayList();
        for (int[] edge : edges) {
            outList[edge[0]].add(edge[1]);
            inCount[edge[1]]++;
        }
        
        // Initialize the processing queue with the nodes that don't 
        // have any incoming edges.  i.e. inComing[node]==0.
        int arrSize = (n + 63) / 64;
        long[][] ancestors = new long[n][arrSize];
        int[] que = new int[n];
        int queIn = 0;
        int queOut = 0;
        for (int i = 0; i < n; i++) 
            if (inCount[i] == 0)
                que[queIn++] = i;

        // Repeatedly process nodes that no longer have any in-coming 
        // edges.  For each processed node, propagate the ancestors to 
        // destination nodes.  Disconnect the processed node from its 
        // destination nodes by decrementing the in-coming count for 
        // each destination node.  If the in-coming count goes to zero, 
        // then add the destination node to the queue of nodes without 
        // any in-coming nodes.
        while (queOut < queIn) {
            int node = que[queOut++];
            int bitIdx = node / 64;
            long bitMask = 1L << (node & 63);
            long[] nodeAncestors = ancestors[node];
            for (int toNode : outList[node]) {
                long[] toAncestors = ancestors[toNode];
                for (int j = 0; j < arrSize; j++)
                    toAncestors[j] |= nodeAncestors[j];
                toAncestors[bitIdx] |= bitMask;
                if (--inCount[toNode] == 0)
                    que[queIn++] = toNode;
            }
        }
        
        // Convert the bit-masks of ancestor information for each node 
        // to a List<Integer> of ancestors for that node.
        List<List<Integer>> result = new ArrayList();
        for (int node = 0; node < n; node++) {
            List<Integer> list = outList[node];
            list.clear();
            long[] nodeAncestors = ancestors[node];
            for (int i = 0; i < arrSize; i++) {
                long mask = nodeAncestors[i];
                int ancNode = i * 64;
                while (mask != 0) {
                    if ((mask & 1) != 0)
                        list.add(ancNode);
                    mask >>>= 1;
                    ancNode++;
                }
            }
            result.add(list);
        }
        return result;
    }
}