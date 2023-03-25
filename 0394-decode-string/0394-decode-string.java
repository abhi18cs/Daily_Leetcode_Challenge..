class Solution {
    public String decodeString(String s) {
        Stack<String> result=new Stack<>();
        Stack<Integer> counter=new Stack<>();
        int i=0;
        String res="";
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int count=0;
                while(Character.isDigit(s.charAt(i))){
                count=10*count+(s.charAt(i)-'0');//to convert in to integer
                    i++;
                }
                counter.push(count);
            }
            else if(s.charAt(i)=='['){
                // is opening bracket push processed result onto the stack
                result.push(res);
                res="";i++;
            }
            else if(s.charAt(i)==']'){
                StringBuilder temp=new StringBuilder(result.pop());
                int count=counter.pop();
                for(int j=0;j<count;j++){
                    temp.append(res);
                }
                res=temp.toString();
                i++;
            }
            else{
                res=res+s.charAt(i)+"";
                i++;
            }
        }
        return res;
    }
}