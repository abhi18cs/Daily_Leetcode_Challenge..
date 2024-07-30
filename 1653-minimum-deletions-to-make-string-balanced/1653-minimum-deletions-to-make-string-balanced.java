class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st1 = new Stack<>();
        int count1 =0;
       
        for(char ch : s.toCharArray()){
           if(!st1.isEmpty() && st1.peek()=='b'){
              if(ch =='a'){
                st1.pop();
                count1++;
              }
              else{//ch==b
                st1.push(ch);
              }
           }
           else{
            st1.push(ch);
           }
        }
        return count1;
    }
}