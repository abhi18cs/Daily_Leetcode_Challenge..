class Solution {
    public long putMarbles(int[] weights, int k) {
        // Map<Pair<Integer, Integer>, long[]> memo = new HashMap<>();
        // long[] res = dfs(weights, 0, k, memo);        
        // return res[1] - res[0];
        if(k == 1 || k == weights.length) return 0;
        PriorityQueue<Long> min = new PriorityQueue<>();
        PriorityQueue<Long> max = new PriorityQueue<>((a, b)->{
            return Long.compare(b, a);
        });
        for(int i = 0; i < weights.length - 1; ++i){
            long sum = (long)weights[i] + weights[i + 1];
            min.offer(sum);
            max.offer(sum);
            if(min.size() == k) min.poll();
            if(max.size() == k) max.poll();
        }
        long res = 0;
        while(!max.isEmpty()){
            res += min.poll() - max.poll();
        }
        return res;
    }
    //First smallest, Second largst
    public long[] dfs(int[] weights, int start, int k,  Map<Pair<Integer, Integer>, long[]> memo){
        long[] res = new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        Pair<Integer, Integer> p = new Pair<>(start, k);
        if(memo.get(p) != null) return memo.get(p);
        if(start >= weights.length || weights.length - start + 1 < k){
            memo.put(p, res);
            return res;
        }
        
        if(k == 1){
            res[0] = (long)weights[start] + weights[weights.length - 1];
            res[1] = res[0];
            memo.put(p, res);
            return res;
        }
        for(int i = start; i < weights.length; ++i){
            long[] d = dfs(weights, i + 1, k - 1, memo);
            if(d[0] == Long.MAX_VALUE && d[1] == Long.MIN_VALUE) break;
            res[0] = Math.min(res[0], d[0] + weights[start] + weights[i]);
            res[1] = Math.max(res[1], d[1] + weights[start] + weights[i]);
        }
        memo.put(p, res);
        return res;
    }
}