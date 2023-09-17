class Solution {
    public int shortestPathLength(int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int target = 0;
        for (int i = 0; i < graph.length; i++) {
            int status = (1 << (i+1));
            target = target | (1 << (i+1));
            visited.add(status + ":" + i);
            q.offer(new int[]{status, i});
        }
        int numThisLevel = q.size(), numNextLevel = 0, level = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            numThisLevel --;
            if (cur[0] == target) return level;
            for (int i = 0; i < graph[cur[1]].length; i++) {
                int nextNode = graph[cur[1]][i];
                int nextStatus = cur[0] | (1 << (nextNode + 1));
                if (visited.contains(nextStatus + ":" + nextNode)) continue;
                visited.add(nextStatus + ":" + nextNode);
                q.offer(new int[]{nextStatus, nextNode});
                numNextLevel++;
            }
            if (numThisLevel == 0) {
                numThisLevel = numNextLevel;
                numNextLevel = 0;
                level++;
            }
        }
        return -1;
    }
}