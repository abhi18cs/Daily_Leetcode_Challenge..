class Solution {
    static int MOD = 1_000_000_007;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        
        Arrays.sort(arr);
        
        //consider as root for each number
        //save the count of BT
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        
        //num to index mapping
        Map<Integer, Integer> mapIndex = new HashMap();
        for(int i = 0; i < n; i++)
            mapIndex.put(arr[i], i);
        
        for(int rootIndex = 0; rootIndex < n; rootIndex++){
            int root = arr[rootIndex];
            
            for(int leftIndex = 0; leftIndex < rootIndex; leftIndex++){
                int left = arr[leftIndex];
                
                if(root % left == 0){
                    int right = root / left;
                    
                    if(mapIndex.containsKey(right)){
                        int rightIndex = mapIndex.get(right);
                        
                        dp[rootIndex] = (dp[rootIndex] + (dp[leftIndex] * dp[rightIndex])) % MOD; 
                    }
                }
            }
        }
        
        //count all the trees
        long counts = 0;
        for(long count : dp) counts += count;
        
        
        return (int) (counts % MOD);
    }
}