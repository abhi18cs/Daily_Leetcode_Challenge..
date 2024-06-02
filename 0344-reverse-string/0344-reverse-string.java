//Approach -1 
// class Solution {
//     public void reverseString(char[] s) {
//         char ch;
//         for(int i=0,j=s.length-1;i<s.length/2;i++,j--){
//             ch=s[j];
//             s[j]=s[i];
//             s[i]=ch;
//         }
    
//     }
// }
//Tc=O(n2);
//approach-2 tc=O(n)sc=O(1) 2 pointers
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        
        while(i <= j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}