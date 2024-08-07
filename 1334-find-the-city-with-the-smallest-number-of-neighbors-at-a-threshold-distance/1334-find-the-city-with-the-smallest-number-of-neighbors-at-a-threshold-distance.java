class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    
    ArrayList<int []>[] graph = new ArrayList[n];
    for(int i=0;i<n;i++){
        graph[i] = new ArrayList<>();
    }
    for(int []edge : edges){
        graph[edge[0]].add(new int[]{edge[1],edge[2]});
        graph[edge[1]].add(new int[]{edge[0],edge[2]}); 
    }
    int city = 0;
    int min = n+1; // min can't be greater than n+1;
    
    for(int i=0;i<n;i++){
        int count = bfs(graph,i,distanceThreshold); // do bfs from every node to find out the min number of nodes it visits
        if(count <= min){
            city = i;
            min = count;
        }
    }
    return city;
}
private int bfs(ArrayList<int[]>[] graph,int src,int k){
    
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
    pq.add(new int[]{src,0});
    boolean []vis = new boolean[graph.length];
    int countNodes = -1;  // can be initilaized with zero too (-1 taken to not include the source node)
    while(pq.size()!=0){
        
        int []temp = pq.poll();
        if(vis[temp[0]])continue;
        vis[temp[0]]=true;
        countNodes++;
        for(int []nbr : graph[temp[0]]){
            if(vis[nbr[0]] != true && nbr[1]+temp[1] <= k){ // add only if the totoal distance is at most threshold
                pq.add(new int[]{nbr[0],nbr[1]+temp[1]});
            }
        }
    }
    return countNodes; 
}

}