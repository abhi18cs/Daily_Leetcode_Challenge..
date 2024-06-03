class Solution {
    public int appendCharacters(String s, String t) {
        int idx1=0;
        int idx2=0;
        int n1 = s.length();
        int n2 = t.length();

        while(idx1<n1 && idx2<n2){
            char ch1 = s.charAt(idx1);
            char ch2 = t.charAt(idx2);
            if(ch1==ch2){
                idx1++;
                idx2++;
            }else idx1++;
        }

        return n2-idx2;
    }
}