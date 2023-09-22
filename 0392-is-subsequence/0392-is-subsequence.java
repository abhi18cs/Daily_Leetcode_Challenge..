// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         if(s.length()>t.length()) return false;
//         int j=0;
//         for(int i=0;i<t.length()&&j<s.length();i++){
//             if(s.charAt(j)==t.charAt(i)) j++;
//         }
//         return j==s.length();
//     }
// }

class Solution {
    //TWO POINTER 
    public boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return (i == s.length());
    }
}