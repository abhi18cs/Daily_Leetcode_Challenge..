class Solution {
    public int numberOfBeams(String[] bank) {
       int prev = 0;
        int ans = 0;
        for(String i : bank){
            int cur = 0;
            for(char ch:i.toCharArray()){
                if(ch=='1')
                    cur++;
            }

            if(cur > 0){
                ans += (cur*prev);
                prev = cur;
            }
        }
        return ans;
    }
}