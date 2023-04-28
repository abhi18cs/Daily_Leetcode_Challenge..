class Solution {
    class DisjointSetUnion{
        int[] parent;
        int[] size;
        public DisjointSetUnion(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }     
        }
        int findULP(int i){
            if(parent[i] == i) return i;
            int ulp = findULP(parent[i]);
            return parent[i] = ulp;
        }
        void unionBySize(int u, int v){
            int ulp_u = findULP(u), ulp_v = findULP(v);
            if(ulp_u == ulp_v) return;
            if(size[ulp_u]<size[ulp_v]){
                size[ulp_v] += size[ulp_u];
                parent[ulp_u] = ulp_v;
            }else{
                size[ulp_u] += size[ulp_v];
                parent[ulp_v] = ulp_u;
            }
        }
    }
    public int numSimilarGroups(String[] strs) {
        DisjointSetUnion dsu = new DisjointSetUnion(strs.length);
        for(int i = 0;i<strs.length;i++){
            for(int j = 0;j<strs.length;j++){
                if(i!=j){
                    if(check(strs[i], strs[j])){
                        dsu.unionBySize(i, j);
                    }
                }
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<strs.length;i++){
            int ulp = dsu.findULP(i);
            hs.add(ulp);
        }
        return hs.size();
    }
    public boolean check(String a, String b) {
        int cnt = 0;
        for(int i = 0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
            if(cnt>2) return false;
        }
        return cnt == 0 || cnt == 2;
    }
}