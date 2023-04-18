class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int m=word1.length();
        int n=word2.length();
        int max=Math.max(m,n);
        for(int i=0;i<max;i++){
            if(i>=m){
                sb.append(word2.charAt(i));
            }
            else if(i>=n){
                sb.append(word1.charAt(i));
            }
            else{
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}