class Solution {
    public int strStr(String haystack, String needle) {
        //if the any of the string is 0 then we return 0;
        if(haystack.length()==0 || needle.length()==0) return 0;
        //if the string is present in haystack then we just retutn starting index, 
        //from where our needle string starts
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;        
    }
}