//Tc=O(n) Sc=O(n)
class Solution {
    public int partitionString(String s) {
    int n = s.length();
        int partitionStringCnt = 1;
        Set<Character> set = new HashSet<>();
        int i=0;
        while(i<n){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                partitionStringCnt++;
                set.clear();
                set.add(ch);
            }
            i++;
        }
        return partitionStringCnt;
        
    }
}