class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int curr = arr[i];
            List<Integer> temp = new ArrayList<>();
            if(map.containsKey(curr)) temp = map.get(curr);
            temp.add(i);
            map.put(curr, temp);
            if(temp.size() == curr){
                ans.add(temp);
                map.remove(curr);
            }
        }
        
        return ans;
        
    }
}