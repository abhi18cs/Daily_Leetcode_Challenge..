class Solution {
    
    public int dfs(HashSet<String> words, HashMap<String, Integer> cache, String s) {
        
        if(cache.containsKey(s)) {
            return cache.get(s);
        }
        
        int max = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<s.length(); i++) {
			// creating all possible strings with one character taken out
            sb.deleteCharAt(i);
            String ns = sb.toString();
            if(words.contains(ns)){
                max = Math.max(max, dfs(words, cache, ns));
            }
			// insertng it back for next iteration
            sb.insert(i, s.charAt(i));
        }
        cache.put(s, ++max);
        
        return max;
    }
    
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> cache = new HashMap<>();
        
        HashSet<String> wordSet = new HashSet<>();
        for(String s: words) wordSet.add(s);
        
        int max = 0; 
        for(String w: words) {
            max = Math.max(max, dfs(wordSet, cache, w));
            //System.out.println(w+ " - "+max);
        }
        return max;
    }
}