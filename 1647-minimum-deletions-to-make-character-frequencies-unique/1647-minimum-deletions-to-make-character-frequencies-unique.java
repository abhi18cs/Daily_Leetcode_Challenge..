class Solution {
    public int minDeletions(String s) {
        
		//to store frequencies of each element
		// it is given in constraints that we'll have only lowercase alphabets hence took size = 26
        int[] freq = new int[26];
        
		//counting frequency of each letter
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            freq[index]++;
        }
        
		// using hashset because we want unique elements only in our answer
		// you may use hashmap
        Set<Integer> set = new HashSet<>();
        int ans = 0; //if there are nothing to delete then our ans will be 0
        
        for(int i=0; i<26; i++){
		//if we have freq as 0 then we can not decrease its freq further
		//if we can not add the freqenecy means we're having duplicate frequence hence decrease the frequency by 1;
		//it means that we've performed one deletion and hence increase the ans by 1
            while(freq[i] != 0  && !set.add(freq[i])){
                --freq[i];
                ans++;
            }
        }
        return ans;
    }
}