class Solution {
    public List<String> buildArray(int[] tar, int n) {
        List<String> ans = new ArrayList<>();

        int count = 1;

        for(int i=0; i<tar.length; i++){
            ans.add("Push");

            if(tar[i]!=count){
                ans.add("Pop");
                i--;
            }
            count++;
        }

        return ans;
    }
}