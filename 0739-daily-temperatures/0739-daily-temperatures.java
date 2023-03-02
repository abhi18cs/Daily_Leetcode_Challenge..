class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=n-1;i>=0;i--){
        //checks until a greater no is found
            while(!st.isEmpty() && temp[st.peek()]<=temp[i]){
                ans[i] += ans[st.peek()]; // add the count of prev no
                st.pop();
            }
            if(!st.isEmpty())
                ans[i]++;
            else ans[i] = 0; // if no is greater than rest then whole
            st.push(i);//stack will be emptied thus make the ans[i]=0
        }                          
        return ans;
    }
}