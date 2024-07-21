class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int idx[][] = new int[k][2];
        int rowadj[][] = new int[k][k];
        for(int[]ele:rowConditions){
            int s = ele[0];
            int e = ele[1];
            rowadj[s-1][e-1] = 1;
        }
        int coladj[][] = new int[k][k];
        for(int[]ele:colConditions){
            int s = ele[0];
            int e = ele[1];
            coladj[s-1][e-1] = 1;
        }
        Stack<Integer> s = new Stack<>();
        int visited[] = new int[k];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                if(!dfs(rowadj,visited,i,s)) return new int[0][0];
            }
        }
        int z=0;
        while(!s.isEmpty()){
            int ele = s.pop();
            idx[ele][0] = z++;
        }
        System.out.println();
        int visited1[] = new int[k];
        for(int i=0;i<visited1.length;i++){
            if(visited1[i]==0){
                if(!dfs(coladj,visited1,i,s)) return new int[0][0];
            }
        }
        z=0;
        while(!s.isEmpty()){
            int ele = s.pop();
            idx[ele][1] = z++;
        }
        int[][] res = new int[k][k];
        z=1;
        for(int[] ele:idx){
            res[ele[0]][ele[1]] = z++;
        }
        return res;
    }
    public static boolean dfs(int[][] adj,int[] visited,int cur,Stack<Integer> s){
        visited[cur] = 1;
        for(int i=0;i<adj.length;i++){
            int nex = adj[cur][i];
            if(nex==1 && visited[i]==1){
                return false;
            }else if(nex==1 && visited[i]==0){
                if(!dfs(adj,visited,i,s)) return false;
            }
        }
        visited[cur]=2;
        s.push(cur);
        return true;
    }
}
