//The idea is simple we use two stack in this problem one for storing the string and second for storing the integer value.

class Solution {
    public String decodeString(String s) {
        // stack to store integer value
        Stack<Integer> counter = new Stack();
        // stack to store String
        Stack<String> result = new Stack();
        int index = 0;
        String res="";

        while(index<s.length()){
            // we use Character class here to checkwhether character is digit or not
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                //If character is digit then loop the character untill you find non-digit character
                while(Character.isDigit(s.charAt(index))){
                   //to convert string to integer
                    count = 10 * count+(s.charAt(index)-'0');
                    index++;
                }
                counter.push(count);
            }
            else if(s.charAt(index)=='['){
                // is opening bracket push processed result onto the stack
                result.push(res);
                res="";
                index++;
            }
            else if(s.charAt(index)==']'){
                // If closing bracket then pop result from stack and append it to temp 
                StringBuilder temp = new StringBuilder(result.pop());
                // pop the counter
                int count = counter.pop();

                // append the current res count times to temp
                for(int i=0;i<count;i++){
                    temp.append(res);
                }
                // assign temp to res
                res = temp.toString();
                index++;
            }
            else{
                // In case you encounter only character of sequence before brackets the compute character String
                res += s.charAt(index)+"";
                index++;
            }
        }

        return res;
    }
}