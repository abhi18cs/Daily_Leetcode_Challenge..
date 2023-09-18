class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a).equals(map.get(b))?b.compareTo(a):map.get(b)-map.get(a));
        
        for(int i=0;i<mat.length;i++){
            int low=0,high=mat[i].length-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(mat[i][mid]==1)
                    low=mid+1;
                else
                    high=mid-1;
            }
            map.put(i,low);
            pq.add(i);
            if(pq.size()>k)
                pq.remove();
        }
        
        int[] ans=new int[k];
        int i=ans.length-1;
        while(!pq.isEmpty())
            ans[i--]=pq.remove();
        return ans;
    }
}