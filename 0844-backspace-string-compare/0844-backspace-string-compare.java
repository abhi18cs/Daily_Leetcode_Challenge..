class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack();
        Stack<Character> tt = new Stack();

        for(char ch : s.toCharArray()) {
            if(ch == '#') {
                if(!ss.isEmpty()) {
                    ss.pop();
                }
            } else {
                ss.push(ch);
            }
        }

        for(char ch : t.toCharArray()) {
            if(ch == '#') {
                if(!tt.isEmpty()) {
                    tt.pop();
                }
            } else {
                tt.push(ch);
            }
        }

        StringBuilder sss = new StringBuilder();
        while(!ss.isEmpty()) {
            sss.append(ss.pop());
        }

        StringBuilder ttt = new StringBuilder();
        while(!tt.isEmpty()) {
            ttt.append(tt.pop());
        }

        return sss.toString().equals(ttt.toString());
    }
}