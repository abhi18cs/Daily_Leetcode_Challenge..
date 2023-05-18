class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list = new ArrayList<>();
        boolean[] inDegree = new boolean[n];
        for(int i=0;i<edges.size();i++){
            inDegree[edges.get(i).get(1)] = true;
        }
        for(int i=0;i<n;i++){
            if(!inDegree[i]){
                list.add(i);
            }
        }
        return list;
    }
}