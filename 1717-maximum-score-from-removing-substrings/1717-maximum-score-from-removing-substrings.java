class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack=new Stack<>();
        StringBuilder temp=new StringBuilder("");
        int ans=0;
        if(y>x){
            for(int i=0;i<s.length();i++){
                if(!stack.isEmpty()  &&  s.charAt(i)=='a' && stack.peek()=='b'){
                    stack.pop();
                    ans+=y;
                }
                else{
                    stack.push(s.charAt(i));
                }
            }

            Stack<Character> st=new Stack<>();
            while(!stack.isEmpty()) {
                if(!st.isEmpty() && stack.peek()=='a' && st.peek()=='b'){
                    ans+=x;
                    stack.pop();
                    st.pop();
                }
                else{
                    st.push(stack.pop());
                }
            }
        }

        else{
            for(int i=0;i<s.length();i++){
                if(!stack.isEmpty()  &&  s.charAt(i)=='b' && stack.peek()=='a'){
                    stack.pop();
                    ans+=x;
                }
                else{
                    stack.push(s.charAt(i));
                }
            }

            Stack<Character> st=new Stack<>();
            while(!stack.isEmpty()) {
                if(!st.isEmpty() && stack.peek()=='b' && st.peek()=='a'){
                    ans+=y;
                    stack.pop();
                    st.pop();
                }
                else{
                    st.push(stack.pop());
                }
            }

        }

        return ans;
    }
}