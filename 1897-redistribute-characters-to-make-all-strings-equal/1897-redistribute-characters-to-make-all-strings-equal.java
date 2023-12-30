class Solution {
    public boolean makeEqual(String[] words) {
       int[] arr = new int[26];
        int n = words.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<words[i].length(); j++) arr[words[i].charAt(j)-'a']++;
        }
        for(int i=0; i<26; i++){
            if(arr[i]!=0 && arr[i]%n!=0) return false;
        }
        return true;  
    }
}